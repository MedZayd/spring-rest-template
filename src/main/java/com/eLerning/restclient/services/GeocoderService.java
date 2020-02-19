package com.eLerning.restclient.services;

import com.eLerning.restclient.entities.Site;
import com.eLerning.restclient.json.Geocoding.Response;
import com.eLerning.restclient.json.Geocoding.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class GeocoderService {
   private static final String KEY = "key=b313934fdaa9c4";
   private static final String JSON_FORMAT = "format=json";
   private static final String LIMIT = "limit=1";
   private static final String BASE = "https://eu1.locationiq.com/v1/search.php";

   private final RestTemplate restTemplate;

   public GeocoderService(RestTemplateBuilder builder) {
      this.restTemplate = builder.build();
   }

   public Site getCoordinates(String address) {
      log.info("Running getCoordinates with parameter: '{}'", address);

      String encodedAddress = URLEncoder.encode(address, StandardCharsets.UTF_8);
      log.info("Encoded address: '{}'", encodedAddress);

      String url = String.format("%s?%s&q=%s&%s&%s", BASE, KEY, encodedAddress, JSON_FORMAT, LIMIT);
      log.info("Sending request to: {}", url);
      Result[] result = restTemplate.getForObject(url, Result[].class);

      log.info("Request result: {}", result);

      return new Site(result[0].getDisplayName(), Double.parseDouble(result[0].getLat()), Double.valueOf(result[0].getLon()));
   }
}
