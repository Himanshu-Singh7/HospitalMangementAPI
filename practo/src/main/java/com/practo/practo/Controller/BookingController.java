package com.practo.practo.Controller;

import com.practo.practo.Payload.BookingDto;
import com.practo.practo.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    public ResponseEntity<String> bookAnAppointment(@RequestBody BookingDto bookingDto){

    }
}
