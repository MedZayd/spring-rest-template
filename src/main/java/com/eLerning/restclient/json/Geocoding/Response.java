package com.eLerning.restclient.json.Geocoding;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class Response {
   private List<Result> results;

   public double getLatitude() {
      return Double.valueOf(results.get(0).getLat());
   }

   public double getLongitude() {
      return Double.valueOf(results.get(0).getLon());
   }

   public String getDisplayName() {
      return results.get(0).getDisplayName();
   }
}
