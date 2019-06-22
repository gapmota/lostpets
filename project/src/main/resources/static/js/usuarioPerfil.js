const url_usuario_request = "http://lostpets.azurewebsites.net/usuario/"
const url_gdrive = "https://drive.google.com/uc?id=";
const url_usuario_perfil = "http://lostpets.azurewebsites.net/usuario/"
const url_resq_perfil = "http://lostpets.azurewebsites.net/lostpet/api/petsperdidos/usuario/";
	
	
let url = window.location.href.split("/");
let id = url[url.length - 1];
let $$ = document.getElementById;

function getPontosUsuario(id) {
    $.ajax({
        type: 'GET',
        dataType: 'json',
        headers: {
            'Content-Type': 'application/json'
        },
        url: url_usuario_perfil + "/pontos/40",
        data: null,
        success: function (response) {
        	console.log(response);
            document.getElementById("qnt_pets").textContent = (response / 10)+" pets encontrados";
        },
        error: function () {
        }
    });
}


$.ajax({
    dataType: 'json',
    type: 'GET',
    headers: {
        'Content-Type': 'application/json'
    },
    url: url_usuario_request + "" + id,
    data: '',
    success: function (response) {
    	console.log(response);
        document.getElementById("nome_usuario").textContent = response.nome;
        document.getElementById("regiao_usuario").textContent = response.bairro+" - "+response.uf;
        document.getElementById("contato_usuario").textContent = response.email+" | cell: "+response.telefoneCelular+" | fixo: "+response.telefoneFixo;
        document.getElementById("foto_usuario_perfil").src  = response.idImagem;
        document.getElementById("text_pet_usuario").textContent = "pets de "+response.nome;
        getPontosUsuario(id);
        requestLostPets(id);
    },
    error: function () {
        console.log("pqp");
    }
});


function carregarPets(listPet){
	  
	  let div = document.getElementById("quadros");
	  div.innerHTML = "";
	  
	  listPet.forEach(pet => {
	    div.innerHTML += "<div class='card-lost dp-f' style='height: 460px !important;''>"
	    +"<div class='area_foto'>"
	    +"<img src='"+url_gdrive+pet.pathImg+"' class='foto_pet'>"
	    +"</div>"
	    +"<div>"
	    +"<table>"
	    +"<tr><td class='desc_pet'>nome</td></tr>"
	    +"<tr>"
	    +"<td class='desc_info_pet'>"+pet.nomeAnimal+"</td>"
	    +"</tr>"
	    +"<tr>"
	    +"<td class='desc_pet'>desaparecimento</td>"
	    +"</tr>"
	    +"<tr>"
	    +"<td class='desc_info_pet'>"+pet.dataPerdido+"</td>"
	    +"</tr>"
	    +"<tr>"
	    +"<td class='desc_pet'>região</td>"
	    +"</tr>"
	    +"<tr>"
	    +"<td class='desc_info_pet'>itaquera-sp</td>"
	    +"</tr>"
	    +"<tr>"
	    +"<td class='desc_pet'>status</td>"
	    +"</tr>"
	    +"<tr>"
	    +"<td class='desc_info_pet'>"+(pet.status == "A" ? "animal achado" : "animal perdido")+"</td>"
	    +"</tr>"
	    +"</table>"
	    +"</div>"
	    +"</div>";
	  });
	}


function requestLostPets(id){
    $.ajax({
      type: 'GET',
      dataType: 'json',
      headers: {
          'Content-Type': 'application/json'
      },
      url: url_resq_perfil+id,
      data: null,
      success: function (response) {
    	  console.log(response);
    	  carregarPets(response);
      },
      error: function () {
      }
    });  
}
