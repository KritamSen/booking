package com.booking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
public class RouteDTO {
    private Long id;

    @NotEmpty(message="Origin cannot be empty")
    @Size(min=2 , max=100, message="Origin must be required")
    private String origin;

    @NotEmpty(message="Destination cannot be empty")
    @Size(min=2 , max=100, message="Destination must be required")
    private String destination;

    @NotNull(message="Card number cannot be empty")
    private Double distance;


    private Date createdAt;

    private Date updatedAt;

}
