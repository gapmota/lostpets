const url_resq = "http://localhost:8080/lostpet/api/petsperdidos/";
const url_session = "http://localhost:8080/session"
const url_animaisAchados = "http://localhost:8080/animaisAchados/"

const usuario = null;

function requestUsuarioSession(){
    $.ajax({
      type: 'GET',
      dataType: 'json',
      headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
      },
      url: url_session + "/usuario",
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
          'Content-Type': 'application/x-www-form-urlencoded'
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