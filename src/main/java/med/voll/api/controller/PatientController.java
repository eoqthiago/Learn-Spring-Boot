package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.patient.Patient;
import med.voll.api.patient.PatientRepository;
import med.voll.api.patient.dto.FindCustom;
import med.voll.api.patient.dto.RegisterPatient;
import med.voll.api.patient.dto.Update;

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
	
	@GetMapping
	public Page<FindCustom> findCustom(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
		return patientRepository.findAll(paginacao).map(FindCustom::new);
	}
	
	@PutMapping
	@Transactional
	public void update(@RequestBody @Valid Update dados) {
		var patient = patientRepository.getReferenceById(dados.id());
		patient.updateData(dados);
	}
}
