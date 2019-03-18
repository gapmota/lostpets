function viewLostPet(){

	let view = document.getElementById("viewLostPet");

	if(view.className == "lostOn"){
		view.className = "lostOff";
	}else{
		view.className = "lostOn";
	}
}

function viewRegister(){
	
	let view = document.getElementById("viewRegister");

	if(view.className == "registerOn"){
		view.className = "registerOff";
	}else{
		view.className = "registerOn";
	}
}

document.getElementById("btn_perdi").onclick = function (){
	viewLostPet();
};


document.getElementById("btn_cadastro").onclick = function (){
	viewRegister();
};
