package com.projects.testMax.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projects.testMax.entity.Questions;
import com.projects.testMax.service.QuestionsService;

@Controller
public class AdminController {
	@Autowired
	QuestionsService questionService;
	
	@RequestMapping(value="question", method=RequestMethod.POST)
	public ModelAndView addQuestion(@RequestParam String question, @RequestParam String optionsList, @RequestParam char correctVal, @RequestParam String course) throws IOException{
		question = question.trim();
		optionsList = optionsList.trim();
		Questions questionObj = new Questions();
		questionObj.setqString(question);
		questionObj.setCorrectAnswer(correctVal);
		questionObj.setCourse(course);
		questionObj.setOptionList(optionsList);
		questionService.addQuestion(questionObj);
		return new ModelAndView("adminPanel");
	}
}
