package com.projects.testMax.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
//	@RequestMapping(value="submitTest", method = RequestMethod.POST)
//	public ModelAndView submitTest(@RequestParam char question1,@RequestParam char question2,@RequestParam char question3,@RequestParam char question4,@RequestParam char question5, @RequestParam String qIdList) throws IOException{
//		 String ansList = 
//		questionService.evaluateTest();
//		return new ModelAndView("login");
//	}
	
	
	@RequestMapping(value="submitTest", method = RequestMethod.POST)
	public @ResponseBody
	Integer submitTest(@RequestParam String qIdList, @RequestParam String ansList) throws IOException{
		int result = questionService.evaluateTest(qIdList, ansList);
		return result;
	}
}
