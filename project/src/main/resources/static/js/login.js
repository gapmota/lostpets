$(document).ready(function () {

	$(document).ready(function () {
		$('select').formSelect();
	});


	$('.carousel').carousel(
		{
			dist: 0,
			padding: 0,
			fullWidth: true,
			indicators: true,
			duration: 100,
		}
	);

	autoplay()
	function autoplay() {
		$('.carousel').carousel('next');
		setTimeout(autoplay, 4500);
	}

});


let url_pdf = window.location.href;
let split_pdf = url_pdf.split("?id=");

console.log();
if(split_pdf[1] != undefined){
	window.open('https://drive.google.com/uc?id='+split_pdf[1],'_blank');
}











