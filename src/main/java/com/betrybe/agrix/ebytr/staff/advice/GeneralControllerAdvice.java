package com.betrybe.agrix.ebytr.staff.advice;

import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.exceptions.CropNotFound;
import com.betrybe.agrix.ebytr.staff.service.exceptions.FarmNotFound;
import com.betrybe.agrix.ebytr.staff.service.exceptions.FertilizerNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type General controller advice.
 */
@ControllerAdvice
public class GeneralControllerAdvice {

  /**
   * Handle farm not found response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler(FarmNotFound.class)
  public ResponseEntity<String> handleFarmNotFound(FarmNotFound e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fazenda não encontrada!");
  }

  /**
   * Handle crop not found response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler(CropNotFound.class)
  public ResponseEntity<String> handleCropNotFound(CropNotFound e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plantação não encontrada!");
  }

  /**
   * Handle fertilizer not fount response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler(FertilizerNotFound.class)
  public ResponseEntity<String> handleFertilizerNotFount(FertilizerNotFound e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fertilizante não encontrado!");
  }


  @ExceptionHandler(PersonNotFoundException.class)
  public ResponseEntity<String> handlePersonNotFound(PersonNotFoundException e) {
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Pessoa não encontrada");
  }

  /**
   * Handle generic response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler
  public ResponseEntity<String> handleGeneric(RuntimeException e) {
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Erro interno!");
  }
}
