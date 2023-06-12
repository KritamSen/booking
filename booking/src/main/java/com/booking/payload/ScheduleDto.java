package com.booking.payload;

import com.booking.entities.Bus;
import com.booking.entities.Route;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto {

    private Long id;
    private Bus bus;
    private Route route;
    private Date departureTime;
    private Date arrivalTime;
    private long price;
    private Date createdAt;
    private Date updatedAt;
    private Long busId;
    private Long routeId;


    public Long getBusId() {
        return busId;
    }

    public Long getRouteId() {
        return routeId;
    }
}
