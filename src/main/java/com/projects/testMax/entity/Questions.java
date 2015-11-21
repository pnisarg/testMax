package com.projects.testMax.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity	
public class Questions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int qId;
	@Lob
	private String qString;
	@Lob
	private String optionsList;
	private String course;
	//correct Answer value will not be passed to client
	@JsonIgnore
	private char correctAnswer;
	
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public String getqString() {
		return qString;
	}
	public void setqString(String qString) {
		this.qString = qString;
	}
	public String getOptionList() {
		return optionsList;
	}
	public void setOptionList(String optionsList) {
		this.optionsList = optionsList;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public char getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(char correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	@Override
	public String toString() {
		return "Questions [qId=" + qId + ", qString=" + qString
				+ ", optionList=" + optionsList + ", course=" + course
				+ ", correctAnswer=" + correctAnswer + "]";
	}
	
	
	
}
