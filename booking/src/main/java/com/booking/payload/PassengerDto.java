package com.booking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class PassengerDto {

    private Long id;
    private Long bookingId;

    @NotEmpty(message="First name cannot be empty")
    @Size(min=2 , max=50, message="First name must be required")
    private String firstName;

    @NotEmpty(message="Last name cannot be empty")
    @Size(min=2 , max=50, message="Last name must be required")
    private String lastName;


    @NotEmpty(message="Age  cannot be empty")
    @Min(value=1, message="Age must be required")
    private Integer age;

    @NotEmpty(message="Gender cannot be empty")
    private String gender;

    @NotEmpty(message="Seat number cannot be empty")
    @Min(value=1, message="Seat number must be required")
    private Integer seatNumber;

}
