package com.cryptowallet.services.interfaces;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

public interface PayPalService {

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException;

    public Payment createPayment(
            String total,
            String currency,
            String method,
            String intent,
            String description,
            String cancelUrl,
            String successUrl) throws PayPalRESTException;
}
