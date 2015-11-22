package com.projects.testMax.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projects.testMax.entity.Questions;
import com.projects.testMax.entity.Review;
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
	
	@RequestMapping(value="review", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List<Review> getReviewQuestions(){
		return questionService.getTest(); 
	}
	
//	@RequestMapping(value="submitTest", method = RequestMethod.POST)
//	public ModelAndView submitTest(@RequestParam char question1,@RequestParam char question2,@RequestParam char question3,@RequestParam char question4,@RequestParam char question5, @RequestParam String qIdList) throws IOException{
//		 String ansList = 
//		questionService.evaluateTest();
//		return new ModelAndView("login");
//	}
	
	
	@RequestMapping(value="submitTest", method = RequestMethod.POST)
	public @ResponseBody
	Integer submitTest(HttpServletResponse response,HttpServletRequest request,@RequestParam String qIdList, @RequestParam String ansList, @RequestParam long timestamp) throws IOException{
		String username = (String) request.getSession().getAttribute("username");
		int result = questionService.evaluateTest(qIdList, ansList);
		questionService.saveTest(username, qIdList, ansList, result, timestamp);
		return result;
	}
}
