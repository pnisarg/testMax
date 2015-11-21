package com.projects.testMax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projects.testMax.entity.Questions;
import com.projects.testMax.service.QuestionsService;

@Controller
public class TestController {
	
	@Autowired
	QuestionsService questionService;
	
	
	@RequestMapping(value="questions", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List<Questions> getQuestions(){
		return questionService.getQuestions(5); //Number of question to be fetched in 5 (can be dynamically passed)
	}
}
