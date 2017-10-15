
Webcam.set({
	width: 320,
	height: 240,
	image_format: 'jpeg',
	jpeg_quality: 90
});
document.addEventListener("DOMContentLoaded", function(event) {
	Webcam.attach('#my_camera');
});





/**/