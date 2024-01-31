package com.betrybe.agrix.ebytr.staff.controllers.dto;

import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;

/**
 * The type Fertilize dto.
 */
public record FertilizeDto(Long id, String name, String brand, String composition) {

  /**
   * To fertilize fertilizer.
   *
   * @return the fertilizer
   */
  public Fertilizer toFertilize() {
    return new Fertilizer(id, name, brand, composition, null);
  }

  /**
   * Fertilize dto fertilize dto.
   *
   * @param fertilizer the fertilizer
   * @return the fertilize dto
   */
  public static FertilizeDto fertilizeDto(Fertilizer fertilizer) {
    return new FertilizeDto(
        fertilizer.getId(),
        fertilizer.getName(),
        fertilizer.getBrand(),
        fertilizer.getComposition());
  }
}
