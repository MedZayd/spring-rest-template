package com.eLerning.restclient.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class JokeServiceTest {

   @Autowired
   private JokeService service;

   @Test
   void getJoke() {
      String joke = service.getJoke("Craig", "Walls");
      log.info(joke);
      assertTrue(joke.contains("Craig") || joke.contains("Walls"));
   }
}