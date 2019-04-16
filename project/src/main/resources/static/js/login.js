function viewLostPet(){

	let view = document.getElementById("viewLostPet");

	if(view.className == "lostOn"){
		view.className = "lostOff";
		window.history.pushState("String", "Title", "/LostPets");
	}else{
		view.className = "lostOn";
		//Muda url do site sem carregar a mesma
		window.history.pushState("String", "Title", "/LostPets/animalPerdido");
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

function validarPreenchimento(form){
	
	var validou = false;
	var campoLogin = form.login;
	var campoSenha = form.senha;
	var login = campoLogin.value;
	var senha = campoSenha.value;
	
	if(login.lenght == 0){
		alert("Login não foi preenchido");
		campoLogin.focus();
	} 
	else if(senha.lenght == 0){
		alert("Senha não foi preenchido");
		campoSenha.focus();
	}
	else if(login.lenght == 0 && senha.lenght == 0){
		alert("Os campos devem ser preenchidos")
		campoLogin.focus();
	}
	else {
		validou = true;
	}
	
	return validou;
	
}

document.getElementById("btn_perdi").onclick = function (){
	viewLostPet();
};


document.getElementById("btn_cadastro").onclick = function (){
	viewRegister();
};

document.getElementById("foto_register").onclick = function(){
	let file = document.getElementById("files");
	file.click();
}

let ft_register = document.getElementById("foto_register");

ft_register.onclick = function(){
	let file = document.getElementById("files");
	file.click();
	var reader  = new FileReader();
	
	reader.onloadend = function () {
		ft_register.style.backgroundImage = reader.result;
	}

	if (file) {
		reader.readAsDataURL(file);
	} else {
		ft_register.style.backgroundImage = "";
	}
	

}