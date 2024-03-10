package com.practo.practo.Service.Impl;
import com.practo.practo.Entity.Doctor;
import com.practo.practo.Repository.DoctorRepository;
import com.practo.practo.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor addDoctor(Doctor doctor) {

        return this.doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> searchDoctorsByNameAndSpecialization(String search) {
        return doctorRepository.searchDoctorsByNameAndSpecialization("%" + search + "%");
    }
}
