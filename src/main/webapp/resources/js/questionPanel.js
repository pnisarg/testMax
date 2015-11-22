$(document).ready(function(){
	qIdList = [];
	noOfQuestion = 0;
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
	
	$('#submitTest').click(function(){
		var ansList = "";
		var qList = qIdList.join();
		//Dynamically creating answer list. Works for any number of questions
		for(var i=1; i< noOfQuestion; i++)
			ansList += $('#question'+i+' input[type=radio]:checked').val()+",";
		ansList += $('#question'+i+' input[type=radio]:checked').val();
		
		$.ajax({
			url: './submitTest',
			method: 'POST',
			data:{
				'ansList':ansList,
				'qIdList':qList
			},
			success: displayResult
		});
	});
});

function displayResult(result){
	var container = $('#questionContainer').html('');
	var resultString = "Total: "+result;
	var resultDiv = $('<div class="displayResult" align="center">');
	resultDiv.append(resultString);
	container.append(resultDiv);
}
optionMap = ['a','b','c','d','e','f','g'];

function successFunction(result){
	var qPanel = $('#questionPanel').html('');
	noOfQuestion = result.length;
	for(var i=0; i< noOfQuestion; i++){
		qIdList.push(result[i].qId);
		var temp = '<div class="questionDiv" id="question'+(i+1)+'">';
		var question = $(temp);
		var option;
		var optionListNode = $('<div class="optionList">');
		var optionList = result[i].optionList.split('|');
		for(var j=0; j< optionList.length; j++){
			option = '<input type="radio" name="question'+(i+1)+'" value="'+optionMap[j]+'" >';
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
	$('#hiddenqIdList').val(qIdList);
	$('.questionDiv').hide();
	$('#question1').show();
	
}