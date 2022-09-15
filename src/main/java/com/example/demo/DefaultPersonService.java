package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DefaultPersonService implements PersonService {

  private PersonRepository personRepository;

  @Autowired
  public DefaultPersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public Person getPersonById(String id) {
    return personRepository.findById(id).orElseThrow();
  }
}
