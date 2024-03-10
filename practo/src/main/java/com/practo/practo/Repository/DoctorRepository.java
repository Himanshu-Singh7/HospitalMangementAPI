package com.practo.practo.Repository;

import com.practo.practo.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor , Long> {

    @Query("SELECT d FROM Doctor d WHERE d.name LIKE %:search% OR d.specializations LIKE %:search%")
    List<Doctor> searchDoctorsByNameAndSpecialization(@Param("search") String search);
}
