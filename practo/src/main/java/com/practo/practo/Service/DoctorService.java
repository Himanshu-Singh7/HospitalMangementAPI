package com.practo.practo.Service;

import com.practo.practo.Entity.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor addDoctor(Doctor doctor);

    List<Doctor> searchDoctorsByNameAndSpecialization(String search);
}
