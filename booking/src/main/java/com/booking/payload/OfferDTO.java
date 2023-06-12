package com.booking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class OfferDTO {

    private Long id;


    @NotEmpty(message="Offer name cannot be empty")
    @Size(min=2 , max=100, message="Offer name must be required")
    private String offerName;


    @NotEmpty(message="Promo code cannot be empty")
    @Size(min=2 , max=50, message="Promo code must be required")
    private String promoCode;


    @NotEmpty(message="Discount type cannot be empty")
    private String discountType;


    @NotEmpty(message="Discount value cannot be empty")
    private String discountValue;


    @NotEmpty(message="Start date cannot be empty")
    private String startDate;


    @NotEmpty(message="End date cannot be empty")
    private String endDate;





}
