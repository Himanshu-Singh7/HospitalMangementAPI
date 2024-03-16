package com.practo.practo.Controller;
import com.practo.practo.Payload.BookingDto;
import com.practo.practo.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    //http://localhost:9191/api/bookings/saveBooking
    @Autowired
    private BookingService bookingService;

    @PostMapping("/saveBooking")
    public ResponseEntity<String> bookAnAppointment(@RequestBody BookingDto bookingDto){
     this.bookingService.bookAnAppointment(bookingDto);
     return new ResponseEntity<>("Booking is confirmed", HttpStatus.CREATED);
    }
}
