package com.booking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class BusDTO {
    private Long id;
    private Long operatorId;

    private String busType;

    private int totalSeats;

    private String amenities;

    private Date updatedAt;



    private Date createdAt;

}
