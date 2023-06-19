package com.example.aniaj;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize
@Data
public class Przedmiot {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nazwa")
    private String name;
    @JsonProperty("pECTS")
    private Integer etcs;
    @JsonProperty("sala")
    private Integer sala;
    @JsonProperty("egzamin")
    private Boolean egzamin;

}
