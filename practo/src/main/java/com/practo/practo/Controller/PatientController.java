package com.practo.practo.Controller;
import com.practo.practo.Entity.Patient;
import com.practo.practo.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    //http://localhost:9191/api/patients/savePatients
    @Autowired
    private PatientService patientService;

    @PostMapping("/savePatients")
    public ResponseEntity<Patient> createPatients(@RequestBody Patient patient){
      Patient savePatient = this.patientService.createPatient(patient);
      return new ResponseEntity<>(savePatient, HttpStatus.CREATED);
    }

}
