package com.booking.service;


import com.booking.entities.Schedule;
import com.booking.payload.ScheduleDto;

public interface ScheduleService {

    Schedule createSchedule(ScheduleDto scheduleDto);

    Schedule getScheduleById(Long id);

    Schedule updateSchedule(Long id, ScheduleDto scheduleDto);

    void deleteSchedule(Long id);
}

