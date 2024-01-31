package com.betrybe.agrix.ebytr.staff.controllers;

import com.betrybe.agrix.ebytr.staff.controllers.dto.PersonDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Person controller.
 */
@RestController
@RequestMapping(value = "/persons")
public class PersonController {

  private final PersonService personService;

  /**
   * Instantiates a new Person controller.
   *
   * @param personService the person service
   */
  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * Create person response entity.
   *
   * @param person the person
   * @return the response entity
   */
  @PostMapping()
  public ResponseEntity<PersonDto> createPerson(@RequestBody Person person) {
    Person newPerson = personService.create(person);
    return ResponseEntity.status(HttpStatus.CREATED).body((PersonDto.personDto(newPerson)));
  }

}
