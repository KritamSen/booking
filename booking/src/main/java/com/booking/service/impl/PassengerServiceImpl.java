package com.booking.service.impl;

import com.booking.entities.Passenger;
import com.booking.payload.PassengerDto;
import com.booking.repository.PassengerRepository;
import com.booking.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public Passenger createPassenger(PassengerDto passengerDto) {
        Passenger passenger = new Passenger();
        passenger.setFirstName(passengerDto.getFirstName());
        passenger.setLastName(passengerDto.getLastName());
        passenger.setAge(passengerDto.getAge());
        passenger.setGender(passengerDto.getGender());
        passenger.setSeatNumber(passengerDto.getSeatNumber());
        passenger.setCreatedAt(new Date());
        passenger.setUpdatedAt(new Date());
        return passengerRepository.save(passenger);
    }

    @Override
    public Passenger getPassengerById(Long id) {
        Optional<Passenger> passenger = passengerRepository.findById(id);
        return passenger.orElse(null);
    }

    @Override
    public Passenger updatePassenger(Long id, PassengerDto passengerDto) {
        Optional<Passenger> passengerOptional = passengerRepository.findById(id);
        Passenger passenger = passengerOptional.orElseThrow(null);
        passenger.setFirstName(passengerDto.getFirstName());
        passenger.setLastName(passengerDto.getLastName());
        passenger.setAge(passengerDto.getAge());
        passenger.setGender(passengerDto.getGender());
        passenger.setSeatNumber(passengerDto.getSeatNumber());
        passenger.setUpdatedAt(new Date());
        return passengerRepository.save(passenger);
    }

    @Override
    public void deletePassenger(Long id) {
        Optional<Passenger> passenger = passengerRepository.findById(id);
        passenger.ifPresent(passengerRepository::delete);
    }
}
