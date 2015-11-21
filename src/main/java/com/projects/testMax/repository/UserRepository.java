package com.projects.testMax.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projects.testMax.entity.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, String>{

}
