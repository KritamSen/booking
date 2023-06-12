package com.booking.controller;
import com.booking.entities.Passenger;
import com.booking.payload.PassengerDto;
import com.booking.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping
    public ResponseEntity<Passenger> createPassenger(@RequestBody PassengerDto passengerDto) {
        Passenger passenger = passengerService.createPassenger(passengerDto);
        return ResponseEntity.ok(passenger);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPassengerById(@PathVariable Long id) {
        Passenger passenger = passengerService.getPassengerById(id);
        return ResponseEntity.ok(passenger);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePassenger(@PathVariable Long id, @RequestBody PassengerDto passengerDto) {
        Passenger passenger = passengerService.updatePassenger(id, passengerDto);
        return ResponseEntity.ok(passenger);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
        return ResponseEntity.ok().build();
    }
}

