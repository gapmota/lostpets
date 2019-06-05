window.onload = function() {
	//document.getElementById("btn-achei-pet").style.display = "none";
	let url = window.location.href.split("/");
	let id = url[url.length-1];

	let url_resq = "http://localhost:9600/lostpet/api/petsperdidos/";
	
	$.ajax({
				dataType : 'json',
				type : 'GET',
				headers : {
					'Content-Type' : 'application/json'
				},
				url : url_resq + "" + id,
				data : '',
				success : function(response) {
					document.getElementById("nome_animal_info_title").textContent = response.nomeAnimal;
					document.getElementById("tipo_animal_info_title").textContent = response.tipoAnimal;
					document.getElementById("nome_animal_info").textContent = response.nomeAnimal;
					document.getElementById("desaparecimento_animal_info").textContent = response.dataPerdido;
					document.getElementById("regiao_animal_info").textContent = "aaa";
					document.getElementById("foto-pet-perdido").src = response.pathImg;
					document.getElementById("id-animal-hidden").value = id;

					addLocalizacaoPetInfo(response.pathImg, response.latitude,
							response.longitude);
					
					
				},
				error : function() {
					console.log("pqp");
				}
			});
	
	requestUsuarioSession();
	
}


	var usuario = null;

	function requestUsuarioSession(){
		
		let url_session = "http://localhost:9600/session/"
		
	    $.ajax({
	      type: 'GET',
	      dataType: 'json',
	      headers: {
	          'Content-Type': 'application/json'
	      },
	      url: url_session + "usuario",
	      data: null,
	      success: function (response) {
	    	  console.log(response.idPessoa);
	    	if(response.idPessoa > 0) {
	    		document.getElementById("btn-achei-pet").style.display = "block";
	    	}else{
	    		document.getElementById("btn-achei-pet").style.display = "none";
	    	}
	      },
	      error: function () {
	    	  document.getElementById("btn-achei-pet").style.display = "none";
	      }
	    });  
	}
	
	

	// Step 1: initialize communication with the platform
	var platform = new H.service.Platform({
		app_id : 'YxULymX19IjsS2pE7KGo',// isso
		app_code : '6isWeBIxu4YmK1hfYF6s1w',// e isso tu pega no dev.heremaps
		useHTTPS : true
	});
	var pixelRatio = window.devicePixelRatio || 1;
	var defaultLayers = platform.createDefaultLayers({
		tileSize : pixelRatio === 1 ? 256 : 512,
		ppi : pixelRatio === 1 ? undefined : 320
	});
	
	
	// map 2

	// Step 2: initialize a map - not specificing a location will give a whole world
	// view.
	var map2 = new H.Map(document.getElementById('mapContainerView'),
			defaultLayers.normal.map, {
				pixelRatio : pixelRatio
			});

	map2.addEventListener('mapviewchange', function() {
		if (map2.getZoom() < 3) {
			map2.setZoom(3);
		}
	});



	
	// Step 3: make the map interactive
	// MapEvents enables the event system
	// Behavior implements default interactions for pan/zoom (also on mobile touch
	// environments)
	var behavior2 = new H.mapevents.Behavior(new H.mapevents.MapEvents(map2));

	// Create the default UI components
	var ui2 = H.ui.UI.createDefault(map2, defaultLayers);

	function moveMapInfo(latitude, longitude) {
		map2.setCenter({
			lat : latitude,
			lng : longitude
		});
		map2.setZoom(20);
	}

	function addLocalizacaoPetInfo(icon_url, latitude, longitude) {
		// var icon2 = new H.map.Icon(icon_url,{size: {w: 30, h: 30}});
		var marker2 = new H.map.Marker({
			lat : latitude,
			lng : longitude
		});// , { icon: icon2 });
		map2.addObject(marker2);
		map2.getViewPort().resize();
		moveMapInfo(latitude, longitude);
	}
	
	document.getElementById("btn-achei-pet").onclick = function(){
		requestAcheiPetPerdido(document.getElementById("id-animal-hidden").value);
	}