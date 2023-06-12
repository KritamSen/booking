package com.booking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UserPaymentMethodDTO {
    private Long id;
    private Long userId;

    @NotEmpty(message="Payment type cannot be empty")
    @Size(min=2 , max=50, message="Payment type must be required")
    private String paymentType;

    @NotEmpty(message="Card number cannot be empty")
    @Size(min=2 , max=50, message="Card number must be required")
    private String cardNumber;

    @NotEmpty(message="Expiration date cannot be empty")
    private String expirationDate;

    @NotEmpty(message="Card holder name cannot be empty")
    @Size(min=2 , max=100, message="Card holder name must be required")
    private String cardHolderName;



}
