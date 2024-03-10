package com.practo.practo.Service.Impl;
import com.practo.practo.Entity.Doctor;
import com.practo.practo.Entity.Patient;
import com.practo.practo.Entity.Review;
import com.practo.practo.Exception.ResourceNotFoundException;
import com.practo.practo.Repository.DoctorRepository;
import com.practo.practo.Repository.PatientRepository;
import com.practo.practo.Repository.ReviewRepository;
import com.practo.practo.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ReviewRepository reviewRepository;


    @Override
    public Review createReview(Review review) {

      Doctor doctor =  this.doctorRepository.findById(review.getDoctorId()).orElseThrow(() -> new ResourceNotFoundException("Doctor", "doctor id", review.getDoctorId()));
      Patient  patient = this.patientRepository.findById(review.getPatientId()).orElseThrow(() -> new ResourceNotFoundException("Patient" , "patient id" , review.getPatientId()));
        Review saveReview = null;
      if(doctor != null || patient != null){
          saveReview =  this.reviewRepository.save(review);
      }
        return saveReview;
    }

    @Override
    public List<Review> getReviewByDoctorId(long doctorId) {
       List<Review> reviews = this.reviewRepository.findByDoctorId(doctorId);
       return reviews;
    }
}
