package com.betrybe.agrix.solution;

import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.FarmService;
import com.betrybe.agrix.ebytr.staff.service.exceptions.FarmNotFound;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
public class FarmServiceTest {

  @Autowired
  private FarmService farmService;
  private Farm farm;

  @BeforeAll
  public void instance() {
    farm = new Farm();
    farm.setName("Fazenda A");
    farm.setSize(35D);
  }

  @Test
  @DisplayName("Should create a new Farm.")
  public void createNewFarmTest () {
    Farm returnedFarm = farmService.insertFarm(farm);

    Assertions.assertEquals(returnedFarm, farm);
  }

  @Test
  @DisplayName("Should get Farm by ID and by Username.")
  public void getFarmByIdAndByUsernameTest() {
    Farm farmById = farmService.getFarmById(farm.getId());
    Assertions.assertEquals(farmById.getId(), farm.getId());
    Assertions.assertEquals(farmById.getName(), farm.getName());
    Assertions.assertEquals(farmById.getSize(), farm.getSize());
  }

  @Test
  @DisplayName("Should throws an error when Farm doesn't exists")
  public void notFarmPersonTest() {
    Assertions.assertThrows(FarmNotFound.class, () -> farmService.getFarmById(9999L));
  }
}
