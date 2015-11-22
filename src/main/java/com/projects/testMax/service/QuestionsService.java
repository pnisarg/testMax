package com.projects.testMax.service;

import java.util.List;
import java.util.Map;

import com.projects.testMax.entity.Questions;

public interface QuestionsService {
	public void addQuestion(Questions q);
	public List<Questions> getQuestions(int number);
	public int evaluateTest(String qIdList, String ansList);
	public void populateAnswers();
}
