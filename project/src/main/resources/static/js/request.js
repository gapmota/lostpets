const url_resq = "http://localhost:8080/petperdido/";
const url_session = "http://localhost:8080/session/";
const url_usuario = "http://localhost:8080/usuario/";
const url_animaisAchados = "http://findlostpets.azurewebsites.net/animaisAchados"

var usuario = null;

function requestUsuarioSession(){
    $.ajax({
      type: 'GET',
      dataType: 'json',
      headers: {
          'Content-Type': 'application/json'
      },
      url: url_session + "usuario",
      data: null,
      success: function (response) {
        usuario = response;
      },
      error: function () {
      }
    });  
}

function requestPontosUsuario(){
	
	$("#ranking-add").empty();
    $("#ranking-add").append("<tr>"
              	+"<th>Posição</th>"
              	+"<th>Nome</th>"
              	+"<th>Pontos</th>"
              	+"<th>Achados</th>"
              	+"</tr>");
    
	
  $.ajax({
    type: 'GET',
    dataType: 'json',
    headers: {
        'Content-Type': 'application/json'
    },
    url: url_usuario + "/pontos",
    data: null,
    success: function (response) {
      let pos = 0;
      
      response.forEach(ponto => {
    	  
    	  $("#ranking-add").append("<tr>"
    			  +"<td>"+(++pos)+"</td>"
    			  +"<td>"+ponto.nomeUsuario+"</td>"
    			  +"<td>"+ponto.pontos+"</td>"
    			  +"<td>"+ponto.quantidadePetsAchados+"</td>"
    			  +"</tr>");
    	  
        
      });
    },
    error: function () {
    }
  });  
}
  
  
function requestLostPets(){
    $.ajax({
      type: 'GET',
      dataType: 'json',
      headers: {
          'Content-Type': 'application/json'
      },
      url: url_resq,
      data: null,
      success: function (response) {
        carregarListaMapa(response);
      },
      error: function () {
      }
    });  
}

function requestLostPetsByNome(nomePet){
  
  $.ajax({
    type: 'GET',
    dataType: 'json',
    headers: {
        'Content-Type': 'application/json'
    },
    url: url_resq+"nome/"+nomePet,
    data: null,
    success: function (response) {
      carregarListaMapa(response);
    },
    error: function () {
    }
  });  
}

function requestAcheiPetPerdido(idAnimalPerdido){

  if(usuario == null || idAnimalPerdido == undefined) { return }
  
  let animalAchadoJSON = {  
       "usuarioAchou":{  
          "idPessoa":usuario.idPessoa,
       },
       "petPerdido":{  
          "idAnimal":idAnimalPerdido
       },
      };  
 
  $.ajax({
    type: 'POST',
    dataType: 'text',
    headers: {
        'Content-Type': 'application/json'
    },
    url: url_animaisAchados,
    data: JSON.stringify(animalAchadoJSON),
    success: function (response) {
      alert(response);
    },
    error: function (error) {
    	alert("erro");
    	console.log(error);
    }
  });  
}