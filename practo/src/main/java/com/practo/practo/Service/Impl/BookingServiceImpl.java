package com.practo.practo.Service.Impl;
import com.practo.practo.Entity.Booking;
import com.practo.practo.Payload.BookingDto;
import com.practo.practo.Repository.BookingRepository;
import com.practo.practo.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class BookingServiceImpl implements BookingService {


    @Autowired
    private BookingRepository bookingRepository;



    @Override
    public void bookAnAppointment(BookingDto bookingDto) {
        List<String> availableTimeSlots = new ArrayList<>();

            availableTimeSlots.add("10:15 AM"); // 10:15 AM
            availableTimeSlots.add("11:15 AM"); // 11:15 AM
            availableTimeSlots.add("12:15 PM"); // 12:15 PM

        Booking booking = new Booking();
            for(String slots : availableTimeSlots){
             if (slots.equals(bookingDto.getBookingTime())){
                booking.setBookingTime(bookingDto.getBookingTime());
                availableTimeSlots.remove(slots);
            }
         }
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> {
            System.out.println("Executing Code every 24 hours...");

            availableTimeSlots.add("10:15 AM"); // 10:15 AM
            availableTimeSlots.add("11:15 AM"); // 11:15 AM
            availableTimeSlots.add("12:15 PM"); // 12:15 PM
        }, 0,24, TimeUnit.HOURS);

         booking.setDoctorID(bookingDto.getDoctorID());
         booking.setPatientID(bookingDto.getPatientID());

         if (booking.getBookingTime() != null){
             this.bookingRepository.save(booking);
         }else {
             System.out.println("Time slot is not available");
         }
    }
}
