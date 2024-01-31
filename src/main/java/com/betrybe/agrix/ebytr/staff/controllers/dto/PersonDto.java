package com.betrybe.agrix.ebytr.staff.controllers.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * The type Person dto.
 */
public record PersonDto(
    Long id,
    String username,
    Role role

) {

  /**
   * Person dto person dto.
   *
   * @param person the person
   * @return the person dto
   */
  public static PersonDto personDto(Person person) {
    return new PersonDto(
        person.getId(),
        person.getUsername(),
        person.getRole()
    );
  }


}
