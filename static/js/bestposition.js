$(document).ready(function() {
	$('#search-result').hide();	
})

function searchButtonClick() {
	console.log("clicked");
	$('#search-result').hide();
	
	var request = [];

	var lines = $('#search-phrase').val().split('\n');
	console.log("lines: ", lines);
	
	for (i in lines) {
		var line = lines[i].split('/');
		console.log("line: ", line);
		
		request.push({"note":line[0], "octave":line[1]});
	}
	
	console.log("request: ", request);
	
	var url = location.origin + '/bestposition/find';
	console.log("Service URL: ", url);
	
	$.ajax({
		headers: { 
	        'Accept': 'application/json',
	        'Content-Type': 'application/json' 
	    },
        url: url,
        method: "POST",
        dataType: "json",
        data: JSON.stringify(request),
        error: function(jqXHR, textStatus, errorThrown ) {
        	$('#search-result').text(textStatus);
        	$('#search-result').show();
        }
    }).then(function(data) {
    	console.log("successed", data);
    	
    	$('#search-result').text('');
    	
    	for (i in data) {
    		var position = data[i];
    		
    		$('#search-result').append(position.string + '/' + position.fret + '/' + position.finger +
    				' (' + position.tone.note + '/' + position.tone.octave + ') ' +
    				position.weight + '\n');
    	}
    	
    	$('#search-result').show();
    	
    });
	
}