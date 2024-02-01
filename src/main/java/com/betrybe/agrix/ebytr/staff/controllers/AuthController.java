package com.betrybe.agrix.ebytr.staff.controllers;

import com.betrybe.agrix.ebytr.staff.controllers.dto.AuthDto;
import com.betrybe.agrix.ebytr.staff.controllers.dto.TokenDto;
import com.betrybe.agrix.ebytr.staff.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Auth controller.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final TokenService tokenService;

  /**
   * Instantiates a new Auth controller.
   *
   * @param authenticationManager the authentication manager
   * @param tokenService          the token service
   */
  @Autowired
  public AuthController(
      AuthenticationManager authenticationManager,
      TokenService tokenService
  ) {
    this.authenticationManager = authenticationManager;
    this.tokenService = tokenService;
  }

  /**
   * Login response entity.
   *
   * @param authDto the auth dto
   * @return the response entity
   */
  @PostMapping("/login")
  public ResponseEntity<TokenDto> login(@RequestBody AuthDto authDto) {
    UsernamePasswordAuthenticationToken usernamePassowrd =
        new UsernamePasswordAuthenticationToken(authDto.username(), authDto.password());

    Authentication auth = authenticationManager.authenticate(usernamePassowrd);
    UserDetails person = (UserDetails) auth.getPrincipal();

    String token = tokenService.generateToken(person);

    return ResponseEntity.ok(new TokenDto(token));
  }
}
