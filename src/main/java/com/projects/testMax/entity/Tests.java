package com.projects.testMax.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Tests {
	@Id
	@GeneratedValue
	private int testId;
	@OneToOne
	private Users uId;
	private String questionList;
	private String userAnswerList;
	private int score;
	private long timestamp;
	
	public Tests(Users user, String questionList, String userAnswerList, int score, long timestamp) {
		this.uId = user;
		this.questionList = questionList;
		this.userAnswerList = userAnswerList;
		this.score = score;
		this.timestamp = timestamp;
	}
	
	public Tests(){
		
	}
	
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public Users getuId() {
		return uId;
	}
	public void setuId(Users uId) {
		this.uId = uId;
	}
	public String getQuestionList() {
		return questionList;
	}
	public void setQuestionList(String questionList) {
		this.questionList = questionList;
	}
	public String getUserAnswerList() {
		return userAnswerList;
	}
	public void setUserAnswerList(String userAnswerList) {
		this.userAnswerList = userAnswerList;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Tests [testId=" + testId + ", uId=" + uId + ", questionList="
				+ questionList + ", userAnswerList=" + userAnswerList
				+ ", score=" + score + ", timestamp=" + timestamp + "]";
	}
	
	
	
	
}
