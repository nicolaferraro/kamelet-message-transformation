package com.github.nicolaferraro.kamelets;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.ExchangeProperty;
import org.apache.camel.builder.RouteBuilder;


public class InsertField {

    public Map process(@ExchangeProperty("field") String field, @ExchangeProperty("value") String value, Map body) {
      if (body == null) {
        body = new HashMap();
      }
      body.put(field, value);
      return body;
    }

}
