package com.projects.testMax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.testMax.entity.Questions;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Integer>{

}
