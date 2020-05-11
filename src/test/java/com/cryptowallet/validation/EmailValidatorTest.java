package com.cryptowallet.validation;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    @Test
    void isNotValid() {
        String test1 = "test_mail@test.mail";
        String test2 = "test.mail@test.mail";
        String test3 = "test_mail@testmail";
        String test4 = "test_mail.mail";
        String test5 = "test_ma.il@testmail";

        Assert.assertFalse(EmailValidator.isNotValid(test1));
        Assert.assertFalse(EmailValidator.isNotValid(test2));

        Assert.assertTrue(EmailValidator.isNotValid(test3));
        Assert.assertTrue(EmailValidator.isNotValid(test4));
        Assert.assertTrue(EmailValidator.isNotValid(test5));
    }
}