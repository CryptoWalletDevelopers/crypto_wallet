package com.cryptowallet.tronModels;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Contract implements Serializable {
    private Parameter parameter;
    private String type;
}
