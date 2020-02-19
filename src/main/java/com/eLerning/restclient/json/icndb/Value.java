package com.eLerning.restclient.json.icndb;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Value {
   private int id;
   private String joke;
   private List<String> categories;
}
