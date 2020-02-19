package com.eLerning.restclient.services;

import com.eLerning.restclient.json.icndb.JokeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class JokeService {

   private static final String BASE = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";

   private RestTemplate restTemplate;

   public JokeService(RestTemplateBuilder builder) {
      restTemplate = builder.build();
   }

   public String getJoke(String first, String last) {
      log.info("Running getJoke service with parameters : first = '{}' and last = '{}'.", first, last);
      String url = String.format("%s&firstName=%s&lastName=%s", BASE, first, last);
      log.info("Sending request to the url : {}", url);
      JokeResponse response = restTemplate.getForObject(url, JokeResponse.class);
      log.info("Request response: {}", response.toString());
      if (response != null) {
         return response.getValue().getJoke();
      }
      return "";
   }
}
