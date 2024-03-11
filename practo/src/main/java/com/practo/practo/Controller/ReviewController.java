package com.practo.practo.Controller;
import com.practo.practo.Entity.Doctor;
import com.practo.practo.Entity.Review;
import com.practo.practo.Exception.ResourceNotFoundException;
import com.practo.practo.Payload.DoctorDto;
import com.practo.practo.Repository.DoctorRepository;
import com.practo.practo.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    //http://localhost:9191/api/reviews/saveReview
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/saveReview")
    public ResponseEntity<Review> createReview(@RequestBody Review review){
        Review saveReview =this.reviewService.createReview(review);
        return new ResponseEntity<>(saveReview, HttpStatus.CREATED);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDto> getReviewsByDoctorId( @PathVariable  long doctorId){
    Doctor doctor = this.doctorRepository.findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("Doctor", "Doctor Id",doctorId));
    List<Review> reviews = this.reviewService.getReviewByDoctorId(doctorId);
    double totalRating = 0;
    for(Review review :reviews){
        totalRating += review.getRating();
    }
    double averageRating =  totalRating/ reviews.size();
    double maxRating = 5;
    double ratingPercentage = (averageRating / maxRating) * 100;
    DoctorDto doctorDto = new DoctorDto();
    doctorDto.setDoctor(doctor);
    doctorDto.setReviews(reviews);
    doctorDto.setRatingPercentage(ratingPercentage);
    return new ResponseEntity<>(doctorDto , HttpStatus.OK);
    }
}
