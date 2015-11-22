package com.projects.testMax.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="submitTest", method = RequestMethod.POST)
	public ModelAndView submitTest(@RequestParam String question1,@RequestParam String question2,@RequestParam String question3,@RequestParam String question4,@RequestParam String question5, @RequestParam String qIdList) throws IOException{
		return new ModelAndView("login");
	}
	
//	@RequestMapping(value="submitTest", method = RequestMethod.POST)
//	public ModelAndView submitTest(@RequestParam List<String> qIdList, @RequestParam List<String> ansList) throws IOException{
//		return new ModelAndView("login");
//	}
}
