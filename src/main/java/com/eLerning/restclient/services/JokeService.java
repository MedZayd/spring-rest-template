package com.eLerning.restclient.services;

import com.eLerning.restclient.json.JokeResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {

   private static final String BASE = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";

   private RestTemplate restTemplate;

   public JokeService(RestTemplateBuilder builder) {
      restTemplate = builder.build();
   }

   public String getJoke(String first, String last) {
      String url = String.format("%s&firstName=%s&lastName=%s", BASE, first, last);
      JokeResponse response = restTemplate.getForObject(url, JokeResponse.class);
      if (response != null) {
         return response.getValue().getJoke();
      }
      return "";
   }
}
