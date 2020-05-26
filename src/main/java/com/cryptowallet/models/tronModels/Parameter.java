package com.cryptowallet.models.tronModels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Parameter implements Serializable {
    private Value value;
    @JsonProperty("type_url")
    private String typeURL;
}
