package com.cryptowallet.validation;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CharSetValidatorTest {
    @Test
    void isNotValid() {
//        good strings
        String test1 = "ThisStringValid";
        String test2 = "this-string@is_v.a.l.i.d";

//        bad strings
        String test3 = "This string not valid because have space";
        String test4 = "this()string%not*valid&because#have†spec☺symbols";

        Assert.assertFalse(CharSetValidator.isNotValid(test1));
        Assert.assertFalse(CharSetValidator.isNotValid(test2));

        Assert.assertTrue(CharSetValidator.isNotValid(test3));
        Assert.assertTrue(CharSetValidator.isNotValid(test4));
    }
}