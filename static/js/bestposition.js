$(document).ready(function() {
	$('#search-result').hide();	
})

function searchButtonClick() {
	console.log("clicked");
	$('#search-result').hide();
	
	var request = {phrase: []};

	var lines = $('#search-phrase').val().split('\n');
	console.log("lines: ", lines);
	
	for (i in lines) {
		var line = lines[i].split('/');
		console.log("line: ", line);
		
		request.phrase.push({"note":line[0], "octave":line[1]});
	}
	
	var url = location.origin + '/bestposition/find';

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