package com.eLerning.restclient.entities;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Site {
   private Integer id;
   private String name;
   private double latitude;
   private double longitude;

   public Site(String name, double latitude, double longitude) {
      this.name = name;
      this.latitude = latitude;
      this.longitude = longitude;
   }
}
