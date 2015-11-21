$(document).ready(function(){
	
	$.ajax({
		url: './questions',
		method: 'GET',
		success: successFunction
	});
	
	$('.questionDiv').hide();
	$('#question1').show();
	
	$(".pagination a").click(function(){
		var page = "#question"+this.childNodes[0].nodeValue;
		$('.questionDiv').hide();
		$(page).show();
	});
});

function successFunction(result){
	var qPanel = $('#questionPanel').html('');
	for(var i=0; i< result.length; i++){
		var temp = '<div class="questionDiv" id="question'+(i+1)+'">';
		var question = $(temp);
		var option;
		var optionListNode = $('<div class="optionList">');
		var optionList = result[i].optionList.split('|');
		for(var j=0; j< optionList.length; j++){
			option = '<input type="radio" name="question'+(i+1)+'" value="'+(i+1)+'" >';
			option += optionList[j]+"<br>";
//			option.append(optionList[j]+"<br>");
			optionListNode.append(option);
		}
		
		var qString = $('<div class="qString lead">');
		qString.append(result[i].qString.trim());
		question.append(qString);
		question.append(optionListNode);
		qPanel.append(question);
		
	}
	$('.questionDiv').hide();
	$('#question1').show();
	
}