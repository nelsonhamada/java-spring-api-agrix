package com.betrybe.agrix.ebytr.staff.controllers.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

public record PersonDto(
    String username,
    String password,
    Role role
) {
  public Person toPerson() {
    Person newPerson = new Person();
    newPerson.setUsername(username);
    newPerson.setPassword(password);
    newPerson.setRole(role);
    return newPerson;
  }

  public static PersonDto personDto(Person person) {
    return new PersonDto(person.getUsername(),null,  person.getRole());
  }

}
