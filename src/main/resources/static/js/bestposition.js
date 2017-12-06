

$(document).ready(function() {
	$('#search-result').hide();

	if (!Cookies.get("options")) {
        loadDefaultOptions();
	}
})

function searchButtonClick() {
	$('#search-result').hide();
	
	var request = {phrase: []};

	var options = Cookies.getJSON("options");
	if (options) {
		request.options = options;
	}

	var lines = $('#search-phrase').val().split('\n');

	for (i in lines) {
		var line = lines[i].split('/');

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

function loadDefaultOptions() {

    $.ajax({
		headers: {
            'Accept': 'application/json'
		},
		url: "/options/default",
		method: "GET"
    }).then(function (data) {
    	Cookies.set("options", data);
    	console.log("Options loaded");
        console.log(Cookies.getJSON("options"));
    });

}