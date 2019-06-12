package com.giacom.databasedemo;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.giacom.databasedemo.domain.Person;
import com.giacom.databasedemo.persistence.PersonRepository;
import com.giacom.databasedemo.service.PersonService;

@SpringBootApplication
public class DatabaseDemoApplication {

    @Autowired
    private PersonService service;

    @Autowired
    private PersonRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseDemoApplication.class, args);
    }

    @PostConstruct
    public void checkIfWorks() {

        repository.deleteAll();

        service.create(new Person("Duke",
                LocalDate.of(2006, 10, 01)));
        service.create(new Person("Forrest",
                LocalDate.of(1999, 05, 15)));

        List<Person> findAll = service.findAll();
        for (Person person : findAll) {
            System.out.println(person.getId() + ":" + person.getName());
        }

    }

}
