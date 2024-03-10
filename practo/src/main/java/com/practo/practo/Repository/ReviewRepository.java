package com.practo.practo.Repository;
import com.practo.practo.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository <Review,Long>{

    List<Review> findByDoctorId(long id);
}
