package com.booking.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDto {

    private Long id;
    private Long useId;
    private  Long scheduleId;

    @NotEmpty(message="Total passengers cannot be empty")
    @Min(value=1, message="Total passengers must be required")
    private String totalPassenger;

    @NotEmpty(message="Total amount cannot be empty")
    @Min(value=0, message="Total amount must be required")
    private String totalAmount;

    private Long paymentMethodId;
    private String status;


}
