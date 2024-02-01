package com.betrybe.agrix.ebytr.staff.controllers;


import com.betrybe.agrix.ebytr.staff.controllers.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.controllers.dto.FertilizeDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import com.betrybe.agrix.ebytr.staff.service.FertilizeService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Crop controller.
 */
@RestController
@RequestMapping("/crops")
public class CropController {
  private final CropService cropService;
  private final FertilizeService fertilizeService;

  /**
   * Instantiates a new Crop controller.
   *
   * @param cropService      the crop service
   * @param fertilizeService the fertilize service
   */
  @Autowired
  public CropController(
      CropService cropService,
      FertilizeService fertilizeService
  ) {
    this.cropService = cropService;
    this.fertilizeService = fertilizeService;
  }

  /**
   * Gets all crops.
   *
   * @return the all crops
   */
  @GetMapping
  @Secured({"ROLE_ADMIN", "ROLE_MANAGER"})
  public ResponseEntity<List<CropDto>> getAllCrops() {
    List<Crop> crops = cropService.getAllCrops();
    List<CropDto> cropDtoList = crops.stream()
        .map(CropDto::cropDto)
        .toList();
    return ResponseEntity.status(HttpStatus.OK).body(cropDtoList);
  }

  /**
   * Gets crop by id.
   *
   * @param id the id
   * @return the crop by id
   */
  @GetMapping("/{id}")
  public ResponseEntity<CropDto> getCropById(@PathVariable Long id) {
    Crop crop = cropService.getCropById(id);
    return ResponseEntity.status(HttpStatus.OK).body(CropDto.cropDto(crop));
  }

  /**
   * Gets crop by harvest date.
   *
   * @param start the start
   * @param end   the end
   * @return the crop by harvest date
   */
  @GetMapping("/search")
  public ResponseEntity<List<CropDto>> getCropByHarvestDate(
      @RequestParam LocalDate start,
      @RequestParam LocalDate end
  ) {
    List<Crop> crops = cropService.getCropByHarvestDate(start, end);
    List<CropDto> cropDtoList = crops.stream()
        .map(CropDto::cropDto)
        .toList();
    return ResponseEntity.status(HttpStatus.OK).body(cropDtoList);
  }

  /**
   * Binding crop to fertilize response entity.
   *
   * @param cropId       the crop id
   * @param fertilizerId the fertilizer id
   * @return the response entity
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> bindingCropToFertilize(
      @PathVariable Long cropId,
      @PathVariable Long fertilizerId
  ) {
    String bindingCropToFertilizer = fertilizeService.bindingCropToFertilize(
        cropId,
        fertilizerId
    );

    return ResponseEntity.status(HttpStatus.CREATED).body(bindingCropToFertilizer);
  }

  /**
   * Gets fertilizers by crop id.
   *
   * @param cropId the crop id
   * @return the fertilizers by crop id
   */
  @GetMapping("/{cropId}/fertilizers")
  public ResponseEntity<List<FertilizeDto>> getFertilizersByCropId(
      @PathVariable Long cropId
  ) {
    List<Fertilizer> fertilizers = fertilizeService.getFertilizersByCropId(cropId);
    List<FertilizeDto> fertilizeDtoList = fertilizers.stream()
        .map(FertilizeDto::fertilizeDto)
        .toList();
    return ResponseEntity.status(HttpStatus.OK).body(fertilizeDtoList);
  }
}
