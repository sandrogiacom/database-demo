package com.giacom.databasedemo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.giacom.databasedemo.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}

