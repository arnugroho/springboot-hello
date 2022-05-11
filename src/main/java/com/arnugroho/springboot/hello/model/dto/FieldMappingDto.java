package com.arnugroho.springboot.hello.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FieldMappingDto {
    private String bird;
    @JsonProperty("humming_bird")
    private String hummingBird;
    private String FALCON;
    private String FARMBird;

    public String getBird() {
        return bird;
    }

    public void setBird(String bird) {
        this.bird = bird;
    }

    public String getHummingBird() {
        return hummingBird;
    }

    public void setHummingBird(String hummingBird) {
        this.hummingBird = hummingBird;
    }

    public String getFALCON() {
        return FALCON;
    }

    public void setFALCON(String FALCON) {
        this.FALCON = FALCON;
    }

    public String getFARMBird() {
        return FARMBird;
    }

    public void setFARMBird(String FARMBird) {
        this.FARMBird = FARMBird;
    }
}
