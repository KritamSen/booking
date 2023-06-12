package com.booking.service.impl;


import com.booking.entities.Schedule;
import com.booking.payload.ScheduleDto;
import com.booking.repository.ScheduleRepository;
import com.booking.service.BusService;
import com.booking.service.RouteService;
import com.booking.service.ScheduleService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private BusService busService;

    @Autowired
    private RouteService routeService;

    @Override
    public Schedule createSchedule(ScheduleDto scheduleDto) {
        Schedule schedule = new Schedule();
        schedule.setBus(busService.getBusById(scheduleDto.getBusId()));
        schedule.setRoute(routeService.getRouteById(scheduleDto.getRouteId()));
        schedule.setDepartureTime(scheduleDto.getDepartureTime());
        schedule.setArrivalTime(scheduleDto.getArrivalTime());
        schedule.setPrice((long) scheduleDto.getPrice());
        schedule.setCreatedAt(scheduleDto.getCreatedAt());
        schedule.setUpdatedAt(scheduleDto.getUpdatedAt());
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule getScheduleById(Long id) {
        Optional<Schedule> schedule = scheduleRepository.findById(id);
        if (!schedule.isPresent()) {
            throw new ResourceNotFoundException("Schedule with id " + id + " not found");
        }
        return schedule.get();
    }

    @Override
    public Schedule updateSchedule(Long id, ScheduleDto scheduleDto) {
        Schedule schedule = getScheduleById(id);
        schedule.setBus(busService.getBusById(scheduleDto.getBusId()));
        schedule.setRoute(routeService.getRouteById(scheduleDto.getRouteId()));
        schedule.setDepartureTime(scheduleDto.getDepartureTime());
        schedule.setArrivalTime(scheduleDto.getArrivalTime());
        schedule.setPrice(scheduleDto.getPrice());
        schedule.setUpdatedAt(scheduleDto.getUpdatedAt());
        return scheduleRepository.save(schedule);
    }

    @Override
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}

