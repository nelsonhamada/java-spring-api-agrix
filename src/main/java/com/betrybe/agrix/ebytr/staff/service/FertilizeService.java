package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.repository.CropRepository;
import com.betrybe.agrix.ebytr.staff.repository.FertilizerRepository;
import com.betrybe.agrix.ebytr.staff.service.exceptions.CropNotFound;
import com.betrybe.agrix.ebytr.staff.service.exceptions.FarmNotFound;
import com.betrybe.agrix.ebytr.staff.service.exceptions.FertilizerNotFound;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Fertilize service.
 */
@Service
public class FertilizeService {

  private final FertilizerRepository fertilizerRepository;
  private final CropRepository cropRepository;

  /**
   * Instantiates a new Fertilize service.
   *
   * @param fertilizerRepository the fertilizer repository
   * @param cropRepository       the crop repository
   */
  @Autowired
  public FertilizeService(
      FertilizerRepository fertilizerRepository,
      CropRepository cropRepository
  ) {
    this.fertilizerRepository = fertilizerRepository;
    this.cropRepository = cropRepository;
  }

  /**
   * Insert fertilizer fertilizer.
   *
   * @param fertilizer the fertilizer
   * @return the fertilizer
   */
  public Fertilizer insertFertilizer(Fertilizer fertilizer) {
    return  fertilizerRepository.save(fertilizer);
  }

  /**
   * Gets fertilizer by id.
   *
   * @param id the id
   * @return the fertilizer by id
   */
  public Fertilizer getFertilizerById(Long id) {
    Optional<Fertilizer> optionalFertilizer = fertilizerRepository.findById(id);
    if (optionalFertilizer.isEmpty()) {
      throw new FertilizerNotFound();
    }
    return optionalFertilizer.get();
  }

  /**
   * Gets all fertilizers.
   *
   * @return the all fertilizers
   */
  public List<Fertilizer> getAllFertilizers() {
    return fertilizerRepository.findAll();
  }

  /**
   * Binding crop to fertilize string.
   *
   * @param cropId      the crop id
   * @param fertilizeId the fertilize id
   * @return the string
   */
  public String bindingCropToFertilize(Long cropId, Long fertilizeId) {
    Optional<Crop> optionalCrop = cropRepository.findById(cropId);
    if (optionalCrop.isEmpty()) {
      throw new CropNotFound();
    }
    Optional<Fertilizer> optionalFertilizer = fertilizerRepository.findById(fertilizeId);
    if (optionalFertilizer.isEmpty()) {
      throw new FertilizerNotFound();
    }
    Crop crop = optionalCrop.get();
    crop.getFertilizer().add(optionalFertilizer.get());
    cropRepository.save(crop);
    return "Fertilizante e plantação associados com sucesso!";
  }

  /**
   * Gets fertilizers by crop id.
   *
   * @param cropId the crop id
   * @return the fertilizers by crop id
   */
  public List<Fertilizer> getFertilizersByCropId(Long cropId) {
    Optional<Crop> optionalCrop = cropRepository.findById(cropId);
    if (optionalCrop.isEmpty()) {
      throw new CropNotFound();
    }
    Crop crop = optionalCrop.get();
    return crop.getFertilizer();
  }
}
