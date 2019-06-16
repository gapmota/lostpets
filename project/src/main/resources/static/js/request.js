const url_resq = "http://lostpets.azurewebsites.net/lostpet/api/petsperdidos/";
const url_session = "http://lostpets.azurewebsites.net/session/"
const url_usuario = "http://lostpets.azurewebsites.net/usuario/"
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
      $("#ranking-add").empty();
      response.forEach(ponto => {
        addRanking(ponto, ++pos);
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