package com.eLerning.restclient.json.icndb;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JokeResponse {
   private String type;
   private Value value;
}
