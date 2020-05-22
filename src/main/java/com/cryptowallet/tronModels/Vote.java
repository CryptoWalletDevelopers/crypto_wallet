package com.cryptowallet.tronModels;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Vote implements Serializable {
    private String voteAddress;
    private Long voteCount;
}
