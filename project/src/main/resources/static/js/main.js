function viewQuadros(){

	let view = document.getElementById("quadros");

	if(view.className == "area_listagem_on"){
		view.className = "area_listagem_off";
	}else{
		view.className = "area_listagem_on";
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

btn_view.onclick = function (){

    if(btn_view.textContent == "map"){
        btn_view.textContent = "lista";
    }else{
        btn_view.textContent = "map";
    }

    viewQuadros();
    viewMap();
};

function moveMap(map){
    map.setCenter({lat:-23.5766, lng:-46.4098 });
    map.setZoom(14);
  }
  
function addMarkersToMap(map) {
    //var loc = new H.map.Marker({lat:-23.5766, lng:-46.4098 });
//map.addObject(loc);
}
  
  //Step 1: initialize communication with the platform
  var platform = new H.service.Platform({
    app_id: 'YxULymX19IjsS2pE7KGo',
    app_code: '6isWeBIxu4YmK1hfYF6s1w',
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
  

function addLocalizacaoPet(icon_url, latitude, longitude){
    var icon = new H.map.Icon(icon_url,{size: {w: 30, h: 30}});
    var marker = new H.map.Marker({ lat:latitude, lng:longitude }, { 
        icon: icon});
    map.addObject(marker);
}

  
  // Now use the map as required...
  addLocalizacaoPet("../img/dog.jpg",-23.5766,-46.4098);
  addLocalizacaoPet("../img/cat.jpg",-23.5344,-46.4515);
  addLocalizacaoPet("../img/nemo.png",-24.0089,-46.4125);
  moveMap(map);
  addMarkersToMap(map);