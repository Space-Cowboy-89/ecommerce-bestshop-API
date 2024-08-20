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
    private Integer id;
    @JsonProperty(required = true)
    private String name;
    @JsonProperty(required = true)
    private String brand;
    @JsonProperty(required = true)
    private String sku;
    @JsonProperty(required = true)
    private String desc;
    @JsonProperty(required = true)
    private Double price;
    @JsonProperty(required = true)
    private Integer quantity;
    private String categoryCode;
    private String discountCode;
}
