package com.practo.practo.Payload;

import com.practo.practo.Entity.Doctor;
import com.practo.practo.Entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

    private Doctor doctor;
    private List<Review> reviews;
}
