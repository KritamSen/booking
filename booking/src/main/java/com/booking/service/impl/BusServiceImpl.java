package com.booking.service.impl;

import com.booking.entities.Bus;
import com.booking.repository.BusRepository;
import com.booking.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Override
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    @Override
    public Bus getBusById(Long id) {
        return busRepository.findById(id).orElse(null);
    }

    @Override
    public Bus saveOrUpdateBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public void deleteBus(Long id) {
        busRepository.deleteById(id);
    }
}

