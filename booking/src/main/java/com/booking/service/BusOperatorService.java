package com.booking.service;

import com.booking.entities.BusOperator;
import com.booking.payload.BusOperatorDTO;

import java.util.List;

public interface BusOperatorService {
    List<BusOperator> getAllBusOperators();
    BusOperator getBusOperatorById(Long id);
    BusOperatorDTO addBusOperator(BusOperatorDTO busOperatorDTO);
    BusOperator updateBusOperator(Long id, BusOperator busOperator);
    void deleteBusOperator(Long id);
}
