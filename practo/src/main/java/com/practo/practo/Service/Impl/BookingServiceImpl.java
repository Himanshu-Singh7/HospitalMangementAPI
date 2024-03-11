package com.practo.practo.Service.Impl;

import com.practo.practo.Entity.Booking;
import com.practo.practo.Payload.BookingDto;
import com.practo.practo.Repository.BookingRepository;
import com.practo.practo.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Override
    public void bookAnAppointment(BookingDto bookingDto) {
        List<LocalDateTime> availableTimeSlots = new ArrayList<>();

            availableTimeSlots.add(LocalDateTime.of(2024, 3, 11, 10, 15)); // 10:15 AM
            availableTimeSlots.add(LocalDateTime.of(2024, 3, 11, 11, 15)); // 11:15 AM
            availableTimeSlots.add(LocalDateTime.of(2024, 3, 11, 12, 15)); // 12:15 PM
           Booking booking = new Booking();

         for(LocalDateTime slots :availableTimeSlots){
             if (slots.equals(bookingDto.getBookingTime())){
                booking.setBookingTime(bookingDto.getBookingTime());
                availableTimeSlots.remove(slots);
            }
         }
        booking.setDoctorID(bookingDto.getDoctorId());
         booking.setPatientID(bookingDto.getPatientId());

         if (booking.getBookingTime() != null){
             this.bookingRepository.save(booking);
         }else {
             System.out.println("Time slot is not available");
         }

    }
}
