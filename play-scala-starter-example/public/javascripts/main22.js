//document.getElementById("take1").onclick = function take_snapshot() {
	
	// take snapshot and get image data

document.getElementById('take1').addEventListener('click', function() {
	Webcam.snap( function(data_uri) {
		// display results in page
		document.getElementById('results').innerHTML = 
			'<h2>Here is your image:</h2>' + 
			'<img src="'+data_uri+'"/>';
	} );
});