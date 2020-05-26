package com.cryptowallet.entities.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Basic interface for requests.
 * Enables including only non null values
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface BasicJson {

}
