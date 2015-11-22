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
		//highlight selected page
		$('.pagination li[class=active]').removeAttr("class");
		this.parentNode.setAttribute("class","active");
		var page = "#question"+this.childNodes[0].nodeValue;
		$('.questionDiv').hide();
		$(page).show();
	});
	
	$('#submitTest').click(function(){
		var ansList = "";
		var qList = qIdList.join();
		//Dynamically creating answer list. Works for any number of questions
		var i;
		for(i=1; i< noOfQuestion; i++){
			if($('#question'+i+' input[type=radio]:checked').length == 0){
				alert("There are some unanswered questions. Please answer all questions before submitting.");
				return;
			}
			ansList += $('#question'+i+' input[type=radio]:checked').val()+",";
		}
		if($('#question'+i+' input[type=radio]:checked').length == 0){
			alert("There are some unanswered questions. Please answer all questions before submitting.");
			return;
		}
		ansList += $('#question'+i+' input[type=radio]:checked').val();
		
		$.ajax({
			url: './submitTest',
			method: 'POST',
			data:{
				'ansList':ansList,
				'qIdList':qList,
				'timestamp':timestamp
			},
			success: displayResult
		});
	});
});
//display result after test is over. Result contains final score evaluated and returned by server.
function displayResult(result){
	var container = $('#questionContainer').html('');
	var total = qIdList.length;
	var correct = result;
	var resultString = "Score: "+correct+"<br>Total questions: "+total;
	var resultDiv = $('<div class="displayResult" align="center">');
	resultDiv.append(resultString);
	container.append(resultDiv);
}
optionMap = ['a','b','c','d','e','f','g'];
timestamp = 0;

//Display questions on screen. result contains list of questions and options
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
		qString.append('<b>Question '+(i+1)+':</b> '+result[i].qString.trim());
		question.append(qString);
		question.append(optionListNode);
		qPanel.append(question);
	}
	$('#hiddenqIdList').val(qIdList);
	$('.questionDiv').hide();
	$('#question1').show();
	timestamp = new Date().getTime();
}