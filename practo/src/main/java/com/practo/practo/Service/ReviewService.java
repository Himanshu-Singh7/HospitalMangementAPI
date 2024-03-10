package com.practo.practo.Service;

import com.practo.practo.Entity.Review;

import java.util.List;

public interface ReviewService {

    Review createReview(Review review);

    List<Review> getReviewByDoctorId(long doctorId);

}
