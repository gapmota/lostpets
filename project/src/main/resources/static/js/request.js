const url_resq = "http://localhost:8080/lostpet/api/petsperdidos/";
const url_session = "http://localhost:8080/session/"
const url_animaisAchados = "http://localhost:8080/animaisAchados/"

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
          "nome":null,
          "telefoneFixo":null,
          "telefoneCelular":null,
          "email":null,
          "idImagem":null,
          "cep":null,
          "rua":null,
          "bairro":null,
          "cidade":null,
          "uf":null,
          "latitude":null,
          "longitude":null,
          "addCadastro":null,
          "ultimoAcesso":null
       },
       "petPerdido":{  
          "idAnimal":idAnimalPerdido,
          "usuario":null,
          "nomeAnimal":null,
          "dataPerdido":null,
          "status":null,
          "descricao":null,
          "tipoAnimal":null,
          "pathImg":null,
          "cep":null,
          "latitude":null,
          "longitude":null,
          "addData":null
       },
       "dataEncontrado":null,
       "pontos":0,
       "latitude":null,
       "longitude":null,
       "status":null,
       "addData":null
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
      alert('animal achado ' + response);
    },
    error: function (error) {
    	console.log(error);
    }
  });  
}