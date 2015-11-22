package com.projects.testMax.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.primitives.Ints;
import com.projects.testMax.entity.Questions;
import com.projects.testMax.entity.Review;
import com.projects.testMax.entity.Tests;
import com.projects.testMax.entity.Users;
import com.projects.testMax.repository.QuestionRepository;
import com.projects.testMax.repository.TestsRepository;

@Service
public class QuestionsServiceImpl implements QuestionsService{
	@Autowired
	QuestionRepository questionRepo;
	@Autowired
	UserService userService;
	@Autowired
	TestsRepository testRepo;
	
	private Map<Integer, Character> answersMap = new HashMap<Integer, Character>();
	

	
	@Override
	/**
	 * This function adds a question into db
	 * @param question - Requires question entity. 
	 * 
	 */
	public void addQuestion(Questions question) {
		questionRepo.save(question);
	}

	@Override
	/**
	 * @param number - number of question to be picked up randomly
	 * @return returns list of questions
	 */
	public List<Questions> getQuestions(int number) {
		long questionCount = questionRepo.count(); // Max count
		// if we want to restrict question between some values ex. pick question only from 10 - 20
		int low = 0; //can be changed dynamically
		int high = (int) questionCount;
		int result;
		List<Questions> qList = new ArrayList<Questions>();
		Random r = new Random();
		List<Integer> checker = new ArrayList<Integer>();
		while(qList.size() < number){
			result = r.nextInt(high-low) + low;
			if(!checker.contains(result)){
				checker.add(result);
				Questions q = questionRepo.findOne(result);
				qList.add(q);
			}
		}
		return qList;
	}

	@Override
	public int evaluateTest(String qIdList, String ansList) {
		String[] qIdstring = qIdList.split(",");
		Integer[] qIds = new Integer[qIdstring.length];
//		for(int i=0;i<qIdstring.length; i++) qIds[i] = Integer.parseInt(qIdstring[i]);
		String[] userAnswers = ansList.split(",");
		int result = 0;
		for(int i=0;i<qIdstring.length; i++){
			if(String.valueOf(answersMap.get(Integer.parseInt(qIdstring[i]))).equals(userAnswers[i]))
				result++;
		}
		return result;
//		Integer[] qIds = (Integer[]) new Integer[qIdstring.length];
//		Iterable<Integer> iterable= Arrays.asList(qIds);
//		List<Questions> questions = questionRepo.findAll(iterable);
	}

	@Override
	@PostConstruct
	public void populateAnswers() {
		List<Questions> questions = questionRepo.findAll();
		for(Questions question : questions){
			answersMap.put(question.getqId(), question.getCorrectAnswer());
		}
	}

	@Override
	public void saveTest(String username, String qIdList, String ansList,
			int result, long timestamp) {
		Users user = userService.getUser(username);
		Tests test = new Tests(user, qIdList, ansList, result, timestamp);
		testRepo.save(test);
	}

	@Override
	public List<Review> getTest() {
		Tests test = testRepo.findOne(10);
		String[] qIdstring = test.getQuestionList().split(",");
		String[] userAnswers = test.getUserAnswerList().split(",");
		//required because question fetched for review can be in any sequence
		Map<Integer, String> quesToUserAnsMap = new HashMap<Integer, String>(); 
		for(int i=0; i<qIdstring.length; i++) quesToUserAnsMap.put(Integer.parseInt(qIdstring[i]), userAnswers[i]);
		int[] qIds = new int[qIdstring.length];
		for(int i=0;i<qIdstring.length; i++) qIds[i] = Integer.parseInt(qIdstring[i]);
		Iterable<Integer> iterable= Ints.asList(qIds);
		List<Questions> questions = questionRepo.findAll(iterable);
		List<Review> reviews = new ArrayList<Review>();
		for(int i=0; i<questions.size(); i++){
			Review r = new Review();
			r.setQuestion(questions.get(i));
			r.setUserAnswer(quesToUserAnsMap.get(questions.get(i).getqId()));
			r.setAnswer(questions.get(i).getCorrectAnswer());
			reviews.add(r);
		}
		return reviews;
	}

}
