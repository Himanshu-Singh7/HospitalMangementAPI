package com.practo.practo.Controller;

import com.practo.practo.Entity.Doctor;
import com.practo.practo.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

 //http://localhost:9191/api/doctors/saveDoctor

    @Autowired
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/saveDoctor")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
        Doctor saveDoctor =this.doctorService.addDoctor(doctor);
        return  new ResponseEntity<>(saveDoctor , HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Doctor>> searchDoctors(
            @RequestParam("search") String search) {
        List<Doctor> doctors = doctorService.searchDoctorsByNameAndSpecialization(search);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
}

