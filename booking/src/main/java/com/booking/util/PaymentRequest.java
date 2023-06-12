package com.booking.util;

import lombok.Data;

@Data
public class PaymentRequest {
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private String cvv;
    private Double amount;
}

