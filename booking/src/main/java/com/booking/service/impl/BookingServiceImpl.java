package com.booking.service.impl;

import com.booking.entities.Booking;
import com.booking.repository.BookingRepository;
import com.booking.service.BookingService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        booking.setCreatedAt(new Date());
        booking.setStatus("Pending");
        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking"+ id));
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking updateBooking(Long id, Booking booking) {
        Booking existingBooking = getBookingById(id);
        existingBooking.setTotalAmount(booking.getTotalAmount());
        existingBooking.setTotalPassenger(booking.getTotalPassenger());
        existingBooking.setPaymentMethod(booking.getPaymentMethod());
        existingBooking.setStatus(booking.getStatus());
        existingBooking.setUpdatedAt(new Date());
        return bookingRepository.save(existingBooking);
    }

    @Override
    public void deleteBooking(Long id) {
        Booking booking = getBookingById(id);
        bookingRepository.delete(booking);
    }

    @Override
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

}
