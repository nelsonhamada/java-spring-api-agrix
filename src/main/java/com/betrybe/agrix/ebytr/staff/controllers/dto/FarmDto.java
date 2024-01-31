package com.betrybe.agrix.ebytr.staff.controllers.dto;

import com.betrybe.agrix.ebytr.staff.entity.Farm;
/**
 * The type Farm dto.
 */

public record FarmDto(Long id, String name, Double size) {

  /**
   * To farm.
   *
   * @return the farm
   */
  public Farm toFarm() {
    return new Farm(id, name, size, null);
  }

  /**
   * Farm dto farm dto.
   *
   * @param farm the farm
   * @return the farm dto
   */
  public static FarmDto farmDto(Farm farm) {
    return new FarmDto(farm.getId(), farm.getName(), farm.getSize());
  }
}
