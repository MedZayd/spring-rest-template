package com.eLerning.restclient.json.Geocoding;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Result {
   private String displayName;
   private String lat;
   private String lon;
}
