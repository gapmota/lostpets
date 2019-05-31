function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#img-person')
                .attr('src', e.target.result)
                .width(150)
                .height(200);
        };

        reader.readAsDataURL(input.files[0]);
    }
}

$("#img-person").click(function(){
	
	$("#file_upload").click();
	
});

function verfImgCampo(){
	console.log("Chamou!");
	if(document.getElementById("file_upload").value == ""){
		alert("Insira uma imagen");
		console.log("Insira img");
		return;
	}
		
}
