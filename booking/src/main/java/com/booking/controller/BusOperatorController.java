package com.booking.controller;

import com.booking.entities.BusOperator;
import com.booking.payload.BusOperatorDTO;
import com.booking.service.BusOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus-operators")
public class BusOperatorController {

    @Autowired
    private BusOperatorService busOperatorService;

    @GetMapping
    public ResponseEntity<List<BusOperator>> getAllBusOperators() {
        List<BusOperator> busOperators = busOperatorService.getAllBusOperators();
        return new ResponseEntity<>(busOperators, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusOperator> getBusOperatorById(@PathVariable("id") Long id) {
        BusOperator busOperator = busOperatorService.getBusOperatorById(id);
        return new ResponseEntity<>(busOperator, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BusOperatorDTO> addBusOperator(@RequestBody BusOperatorDTO busOperatorDTO) {
        BusOperatorDTO savedBusOperator = busOperatorService.addBusOperator(busOperatorDTO);
        return new ResponseEntity<>(savedBusOperator, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusOperator> updateBusOperator(@PathVariable("id") Long id, @RequestBody BusOperator busOperator) {
        BusOperator updatedBusOperator = busOperatorService.updateBusOperator(id, busOperator);
        return new ResponseEntity<>(updatedBusOperator, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBusOperator(@PathVariable("id") Long id) {
        busOperatorService.deleteBusOperator(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

