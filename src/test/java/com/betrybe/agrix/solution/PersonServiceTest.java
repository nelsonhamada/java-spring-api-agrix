package com.betrybe.agrix.solution;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.security.Role;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
public class PersonServiceTest {
  @Autowired
  private PersonService personService;
  private Person person;

  @BeforeAll
  public void instance() {
    person = new Person();
    person.setUsername("Hamada");
    person.setPassword("java");
    person.setRole(Role.ADMIN);
  }

  @Test
  @DisplayName("Should create a new Person.")
  public void createNewPersonTest() {
    Person returnedPerson = personService.create(person);

    Assertions.assertEquals(returnedPerson.getId(), person.getId());
    Assertions.assertEquals(returnedPerson.getUsername(), person.getUsername());
    Assertions.assertEquals(returnedPerson.getPassword(), person.getPassword());
    Assertions.assertEquals(returnedPerson.getRole(), person.getRole());
  }

  @Test
  @DisplayName("Should get Person by ID and by Username.")
  public void getPersonByIdAndByUsernameTest() {
    Person personById = personService.getPersonById(person.getId());
    Person personByUsername = personService.loadUserByUsername(person.getUsername());

    Assertions.assertEquals(personById, person);
    Assertions.assertEquals(personByUsername, person);
  }

  @Test
  @DisplayName("Should throws an error when Person doeasn't exists.")
  public void notFoundPersonTest() {
    Assertions.assertThrows(PersonNotFoundException.class, () -> personService.getPersonById(999999L));
  }

}
