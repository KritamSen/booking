package com.booking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
public class BusOperatorDTO {

    private Long id;

    @NotEmpty(message="Operator name cannot be empty")
    @Size(min=2 , max=100, message="Card number must be required")
    private String operatorName;

    @Email(message="Card number cannot be empty")
    private String contactEmail;

    @NotEmpty(message="Contact number cannot be empty")
    @Size(min=10 , max=15, message="Contact phone must be required")
    private String contactPhone;

    private String logoUrl;

    private Date createdAt;


    private Date updatedAt;

}
