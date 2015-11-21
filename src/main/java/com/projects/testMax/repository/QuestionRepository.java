package com.projects.testMax.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projects.testMax.entity.Questions;

@Repository
public interface QuestionRepository extends CrudRepository<Questions, Integer>{

}
