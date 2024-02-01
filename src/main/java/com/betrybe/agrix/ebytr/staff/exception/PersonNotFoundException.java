package com.betrybe.agrix.ebytr.staff.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Exception for when a person is not found.
 */
public class PersonNotFoundException extends UsernameNotFoundException {

  public PersonNotFoundException() {
    super("Pessoa não encontrada!");
  }

}
