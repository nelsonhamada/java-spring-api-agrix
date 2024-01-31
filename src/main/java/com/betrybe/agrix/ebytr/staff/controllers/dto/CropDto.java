package com.betrybe.agrix.ebytr.staff.controllers.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import java.time.LocalDate;

/**
 * The type Crop dto.
 */
public record CropDto(
    Long id,
    String name,
    Double plantedArea,
    LocalDate plantedDate,
    LocalDate harvestDate,
    Long farmId
) {

  /**
   * To crop.
   *
   * @return the crop
   */
  public Crop toCrop() {
    return new Crop(id, name, plantedArea, plantedDate, harvestDate, null, null);
  }

  /**
   * Crop dto crop dto.
   *
   * @param crop the crop
   * @return the crop dto
   */
  public static  CropDto cropDto(Crop crop) {
    return new CropDto(
        crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getPlantedDate(),
        crop.getHarvestDate(),
        crop.getFarm().getId()
    );
  }
}
