package com.codehero.bestshop.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductRequest {
    @JsonProperty(required = false)
    private String name;
    @JsonProperty(required = false)
    private String categoria;
    @JsonProperty(required = false)
    private String brand;
    @JsonProperty(required = false)
    private String sku;
    @JsonProperty(required = false)
    private String descrizione;
    @JsonProperty(required = false)
    private double prezzo;
    @JsonProperty(required = false)
    private double sconto;
    //Il campo è legato al numero di prodotti da aggiungere/eliminare dal magazzino
    @JsonProperty(required = false)
    private int numProdotto;
}
