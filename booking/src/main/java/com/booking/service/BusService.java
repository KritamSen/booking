package com.booking.service;

import com.booking.entities.Bus;

import java.util.List;

public interface BusService {

    List<Bus> getAllBuses();

    Bus getBusById(Long id);

    Bus saveOrUpdateBus(Bus bus);

    void deleteBus(Long id);
}

