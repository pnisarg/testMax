$(document).ready(function(){
	$('#takeTestButton').click(function(){
		$.ajax({
			url: './questions',
			method: 'GET',
			success: successFunction
		});
	});
	$('.questionDiv').hide();
	$('#question1').show();
	
});
