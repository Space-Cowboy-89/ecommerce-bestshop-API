package com.codehero.bestshop.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    @JsonProperty(required = true)
    private String name;
    @JsonProperty(required = true)
    private String brand;
    @JsonProperty(required = true)
    private String sku;
    @JsonProperty(required = true)
    private String descrizione;
    @JsonProperty(required = true)
    private double price;
    @JsonProperty(required = true)
    private int numProduct;
    private String categoryCode;
    private String discountCode;
}
