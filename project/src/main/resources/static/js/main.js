var url_resq = "http://localhost:8080/api/";

window.onload = function(){
 // requestLostPets();
  alterView();
  var load = document.getElementById("page_load");
  load.parentNode.removeChild(load);
}

function viewQuadros(){

	let view = document.getElementById("quadros");

	if(view.className.includes("area_listagem_on")){
		view.className = "display-flex area_listagem_off";
	}else{
		view.className = "display-flex area_listagem_on";
	}
}

function viewMap(){
	
	let view = document.getElementById("map_area");

	if(view.className == "area_listagem_on"){
		view.className = "area_listagem_off";
	}else{
    view.className = "area_listagem_on";
	}
}

let btn_view = document.getElementById("btn_abrir_nova_view");
console.log("aaaaa");
function alterView(){
  if(btn_view.textContent == "map"){
    btn_view.textContent = "list";
    viewQuadros();
    viewMap();
  }else{
    btn_view.textContent = "map";
    viewQuadros();
    viewMap();
  }
}

btn_view.onclick = function (){
  alterView();
};



function openModal(){
  let view = document.getElementById("modal");

  console.log("aasfaf");

	if(view.classList.contains("popup-off")){
    view.classList.remove("popup-off");
    view.classList.add("popup-on");
	}else{
		view.classList.remove("popup-on");
    view.classList.add("popup-off");
	}
}

















//MAPA

//Step 1: initialize communication with the platform
var platform = new H.service.Platform({
  app_id: 'YxULymX19IjsS2pE7KGo',//isso
  app_code: '6isWeBIxu4YmK1hfYF6s1w',// e isso tu pega no dev.heremaps
  useHTTPS: true
});
var pixelRatio = window.devicePixelRatio || 1;
var defaultLayers = platform.createDefaultLayers({
  tileSize: pixelRatio === 1 ? 256 : 512,
  ppi: pixelRatio === 1 ? undefined : 320
});

//Step 2: initialize a map  - not specificing a location will give a whole world view.
var map = new H.Map(document.getElementById('mapContainer'),
  defaultLayers.normal.map, {pixelRatio: pixelRatio});

//Step 3: make the map interactive
// MapEvents enables the event system
// Behavior implements default interactions for pan/zoom (also on mobile touch environments)
var behavior = new H.mapevents.Behavior(new H.mapevents.MapEvents(map));

// Create the default UI components
var ui = H.ui.UI.createDefault(map, defaultLayers);

function moveMap(map){
	if (navigatora.geolocation) {
		navigator.geolocation.getCurrentPosition(function(loc){
			map.setCenter({lat:loc.coords.latitude, lng:loc.coords.longitude });
			var loc = new H.map.Marker({lat:loc.coords.latitude, lng:loc.coords.longitude });
		    map.addObject(loc);
		});
	}else{
		map.setCenter({lat:-23.5766, lng:-46.4098 });
	}
    map.setZoom(14);
}

function getLocation() {
	   
	}

	function showPosition(position) {
		position.coords.latitude + 
	  "<br>Longitude: " + position.coords.longitude;
	}

function addLocalizacaoPet(icon_url, latitude, longitude){
  var icon = new H.map.Icon(icon_url,{size: {w: 30, h: 30}});
  var marker = new H.map.Marker({ lat:latitude, lng:longitude }, { icon: icon });
  map.addObject(marker);
}


  // Now use the map as required...
addLocalizacaoPet("../img/dog.jpg",-23.5766,-46.4098);
addLocalizacaoPet("../img/cat.jpg",-23.5344,-46.4515);
addLocalizacaoPet("../img/nemo.png",25.0056201,-71.0883606);
moveMap(map);


function carregarListaMapa(listPet){
  
  let div = document.getElementById("quadros");
  //div.innerHTML = "";
  listPet.forEach(pet => {
    div.innerHTML += ""
    +"<div class='quadro_pet'>"
    +"<div class='area_foto'><img src='"+pet.imgUrl+"' alt='' class='foto_pet'></div>"
    +"<table>"
    +"<tr><td class='desc_pet'>nome</td></tr>"
    +"<tr><td class='desc_info_pet'>"+pet.nome+"</td></tr>"
    +"<tr><td class='desc_pet'>desaparecimento</td></tr>"
    +"<tr><td class='desc_info_pet'>"+pet.desaparecimento+"</td></tr>"
    +"<tr><td class='desc_pet'>região</td></tr>"
    +"<tr><td class='desc_info_pet'>"+pet.regiao+"</td></tr>"
    +"<tr><td><button class='btn_info' onclick='openModal()'>+</button></td></tr>"
    +"</table>"				
    +"</div>";

    addLocalizacaoPet(pet.imgUrl, pet.latitude, pet.longitude);
  });
  moveMap(map);
}

function requestLostPets(){
  $.ajax({
    type: 'POST',
    dataType: 'json',
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
    },
    url: url_resq+'pets',
    data: '',
    success: function (response) {
      carregarListaMapa(response);
    },
    error: function () {
    }
  });  
}


