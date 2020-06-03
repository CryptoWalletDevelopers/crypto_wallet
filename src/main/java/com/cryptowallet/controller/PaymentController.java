package com.cryptowallet.controller;

import com.cryptowallet.paypal.PaypalPaymentIntent;
import com.cryptowallet.paypal.PaypalPaymentMethod;
import com.cryptowallet.services.implementations.PaypalServiceImpl;
import com.cryptowallet.utils.URLUtils;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.security.Principal;

@Controller
@Log4j2
@RequestMapping("/paypal")
public class PaymentController {

    public static final String PAYPAL_SUCCESS_URL = "paypal/success";
    public static final String PAYPAL_CANCEL_URL = "paypal/cancel";

    @Autowired
    private PaypalServiceImpl paypalService;

    @GetMapping("/")
    public String paypalPage(Model model){
        return "buy";
    }

    @RequestMapping("/buy/{orderId}")
    public String payForCoins(HttpServletRequest request,
                      HttpServletResponse response,
                      Model model,
                      Principal principal,
                      @PathVariable(value = "orderId") Long orderId){

        String cancelUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_URL;
        String successUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_URL;

        try {
            Payment payment = paypalService.createPayment(
                    String.valueOf(orderId),
                    "RUB",
                    PaypalPaymentMethod.paypal.toString(),
                    PaypalPaymentIntent.sale.toString(),
                    "Покупка в криптовалюты",
                    cancelUrl,
                    successUrl);
            for(Links links : payment.getLinks()){
                if(links.getRel().equals("approval_url")){
                    return "redirect:" + links.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return "redirect:/";
    }

    @GetMapping("cancel")
    public String cancelPay(){
        return "cancel";
    }

    @GetMapping("success")
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if(payment.getState().equals("approved")){
                return "success";
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return "redirect:/";
    }
}
