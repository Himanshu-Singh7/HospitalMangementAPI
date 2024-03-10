package com.practo.practo.Service.Impl;
import com.practo.practo.Entity.Patient;
import com.practo.practo.Repository.PatientRepository;
import com.practo.practo.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
   private  PatientRepository patientRepository;
    @Override
    public Patient createPatient(Patient patient) {
       Patient savedPatient = this.patientRepository.save(patient);

       return savedPatient;
    }
}
