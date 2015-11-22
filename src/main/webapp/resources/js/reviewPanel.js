$(document).ready(function(){
	var username = 
	$.ajax({
		url: './review',
		method: 'GET',
		success: successFunction
	});
	$(".pagination a").click(function(){
		//highlight selected page
		$('.pagination li[class=active]').removeAttr("class");
		this.parentNode.setAttribute("class","active");
		var page = "#reviewquestion"+this.childNodes[0].nodeValue;
		$('.reviewquestionDiv').hide();
		$(page).show();
	});
	
});
var map = {
	'a': 0,
	'b': 1,
	'c': 2,
	'd': 3,
	'e': 4,
	'f': 5
};
optionMap = ['a','b','c','d','e','f','g'];

function successFunction(result){
	console.log(result);
	var qPanel = $('#reviewquestionPanel').html('');
	noOfQuestion = result.length;
	for(var i=0; i< noOfQuestion; i++){
		var temp = '<div class="reviewquestionDiv" id="reviewquestion'+(i+1)+'">';
		var question = $(temp);
		var option;
		var optionListNode = $('<div class="optionList">');
		var optionList = result[i].question.optionList.split('|');
		for(var j=0; j< optionList.length; j++){
			option = "";
			if(map[result[i].userAnswer] == j){
				if(map[result[i].answer] == j)
					option = ' <span class="glyphicon glyphicon-ok" style="color:green"> </span>';
				option += '<input type="radio" name="question'+(i+1)+'" value="'+optionMap[j]+'" disabled checked>';
			}
			else
				option = '<input type="radio" name="question'+(i+1)+'" value="'+optionMap[j]+'" disabled>';
			if(map[result[i].answer] == j){
				option += '<span style="background-color:#99ff99">' + optionList[j] +"</span><br>";
			}else{
				option += optionList[j]+"<br>";
			}
			optionListNode.append(option);
		}
		
		var qString = $('<div class="qString lead">');
		qString.append('<b>Question '+(i+1)+':</b> '+result[i].question.qString.trim());
		question.append(qString);
		question.append(optionListNode);
		qPanel.append(question);
	}
	$('.reviewquestionDiv').hide();
	$('#reviewquestion1').show();
}