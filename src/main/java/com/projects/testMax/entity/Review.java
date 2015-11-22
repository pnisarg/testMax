package com.projects.testMax.entity;


public class Review {
	private Questions question;
	private String userAnswer;
	private char answer;
	public Questions getQuestion() {
		return question;
	}
	public void setQuestion(Questions question) {
		this.question = question;
	}
	public String getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
	public char getAnswer() {
		return answer;
	}
	public void setAnswer(char c) {
		this.answer = c;
	}
	@Override
	public String toString() {
		return "Review [question=" + question + ", userAnswer=" + userAnswer
				+ ", answer=" + answer + "]";
	}
	
}
