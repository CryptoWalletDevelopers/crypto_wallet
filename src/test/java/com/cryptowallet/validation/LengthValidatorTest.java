package com.cryptowallet.validation;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthValidatorTest {

    @Test
    void isNotValid() {
        String test1 = "This String Valid"; // 17

        Assert.assertFalse(LengthValidator.isNotValid(3, 30, test1));
        Assert.assertFalse(LengthValidator.isNotValid(17, 17, test1));

        Assert.assertTrue(LengthValidator.isNotValid(18, 30, test1));
        Assert.assertTrue(LengthValidator.isNotValid(11, 12, test1));
    }
}