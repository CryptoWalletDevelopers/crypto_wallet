package com.cryptowallet.tronModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import javassist.compiler.ast.StringL;
import lombok.Data;

@Data
public class Parameter {
    private Value value;
    @JsonProperty("type_url")
    private String typeURL;
}
