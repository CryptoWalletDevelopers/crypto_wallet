package com.cryptowallet.tronModels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import javassist.compiler.ast.StringL;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Parameter implements Serializable {
    private Value value;
    @JsonProperty("type_url")
    private String typeURL;
}
