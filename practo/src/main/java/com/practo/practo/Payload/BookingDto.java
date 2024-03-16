package com.practo.practo.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    private long doctorID;
    private long patientID;
    private String bookingTime;

}
