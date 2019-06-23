const url_usuario_request = "http://localhost:8080/usuario/"
const url_usuario_perfil = "http://localhost:8080/usuario/"
const url_resq_perfil = "http://localhost:8080/petperdido/usuario/";
	
	
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
        url: url_usuario_perfil + "pontos/"+id,
        data: null,
        success: function (response) {
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
        document.getElementById("nome_usuario").textContent = response.nome;
        if(response.bairro != null){
        document.getElementById("regiao_usuario").textContent = response.bairro+" - "+response.uf;
        }
        document.getElementById("contato_usuario").textContent = response.email+" | cell: "+response.telefoneCelular+" | fixo: "+response.telefoneFixo;
        
        if(response.idImagem != null){
        	document.getElementById("foto_usuario_perfil").src  = response.idImagem;
        }
        
        document.getElementById("text_pet_usuario").textContent = "pets de "+response.nome;
        
        if(response.bairro != null){
        	getPontosUsuario(id);
        }
        requestLostPets(id);
    },
    error: function () {
        
    }
});


function carregarPets(listPet){
	  
	  let div = document.getElementById("quadros");
	  div.innerHTML = "";
	  
	  listPet.forEach(pet => {
	    div.innerHTML += "<div class='card-lost dp-f' style='height: 460px !important;''>"
	    +"<div class='area_foto'>"
	    +"<img src='"+pet.pathImg+"' class='foto_pet'>"
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
	    +"<td class='desc_info_pet'>"+pet.bairro +" - "+pet.uf+"</td>"
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
    	  carregarPets(response);
      },
      error: function () {
      }
    });  
}
