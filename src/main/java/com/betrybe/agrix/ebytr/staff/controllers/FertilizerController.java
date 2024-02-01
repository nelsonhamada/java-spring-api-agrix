package com.betrybe.agrix.ebytr.staff.controllers;

import com.betrybe.agrix.ebytr.staff.controllers.dto.FertilizeDto;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.service.FertilizeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Fertilizer controller.
 */
@RestController
@RequestMapping(value = "/fertilizers")
public class FertilizerController {

  private final FertilizeService fertilizeService;

  /**
   * Instantiates a new Fertilizer controller.
   *
   * @param fertilizeService the fertilize service
   */
  @Autowired
  public FertilizerController(FertilizeService fertilizeService) {
    this.fertilizeService = fertilizeService;
  }

  /**
   * Create fertilize response entity.
   *
   * @param fertilizeDto the fertilize dto
   * @return the response entity
   */
  @PostMapping()
  public ResponseEntity<FertilizeDto> createFertilize(@RequestBody FertilizeDto fertilizeDto) {
    Fertilizer newFertilizer = fertilizeService.insertFertilizer(fertilizeDto.toFertilize());
    return ResponseEntity.status(HttpStatus.CREATED).body(FertilizeDto.fertilizeDto(newFertilizer));
  }

  /**
   * Gets all fertilizers.
   *
   * @return the all fertilizers
   */
  @GetMapping
  @Secured("ROLE_ADMIN")
  public ResponseEntity<List<FertilizeDto>> getAllFertilizers() {
    List<Fertilizer> fertilizers = fertilizeService.getAllFertilizers();
    List<FertilizeDto> fertilizeDtoList = fertilizers.stream()
        .map(FertilizeDto::fertilizeDto)
        .toList();
    return ResponseEntity.status(HttpStatus.OK).body(fertilizeDtoList);
  }

  /**
   * Gets fertilizer by id.
   *
   * @param id the id
   * @return the fertilizer by id
   */
  @GetMapping("/{id}")
  public ResponseEntity<FertilizeDto> getFertilizerById(@PathVariable Long id) {
    Fertilizer fertilizer = fertilizeService.getFertilizerById(id);
    FertilizeDto fertilizeDto = FertilizeDto.fertilizeDto(fertilizer);
    return ResponseEntity.status(HttpStatus.OK).body(fertilizeDto);
  }

}
