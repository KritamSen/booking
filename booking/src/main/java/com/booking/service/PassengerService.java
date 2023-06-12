package com.booking.service;

import com.booking.entities.Passenger;
import com.booking.payload.PassengerDto;

public interface PassengerService {
    Passenger createPassenger(PassengerDto passengerDto);
    Passenger getPassengerById(Long id);
    Passenger updatePassenger(Long id, PassengerDto passengerDto);
    void deletePassenger(Long id);
}

