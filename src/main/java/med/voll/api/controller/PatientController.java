package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.patient.Patient;
import med.voll.api.patient.PatientRepository;
import med.voll.api.patient.dto.RegisterPatient;

@RestController
@RequestMapping("/patients")
public class PatientController {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@PostMapping
	@Transactional
	public void registerPatient(@RequestBody @Valid RegisterPatient dados) {
		patientRepository.save(new Patient(dados));
	}
}
