package com.eLerning.restclient.services;

import com.eLerning.restclient.entities.Site;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class GeocoderServiceTest {

   @Autowired
   private GeocoderService geocoderService;

   @Test
   void getCoordinatesForGoogleHeadquarters() {
      log.info("Requesting GeocoderService.geocoderService method.");
      Site google = geocoderService.getCoordinates("Twin Center Casablanca");
      log.info("GeocoderService.geocoderService method response: {}", google);
      assertEquals(33.59, google.getLatitude(), 0.01);
      assertEquals(-7.63, google.getLongitude(), 0.01);
   }
}