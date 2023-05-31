package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import med.voll.api.domain.patient.Patient;
import med.voll.api.domain.patient.PatientRepository;
import med.voll.api.domain.patient.dto.DataDetail;
import med.voll.api.domain.patient.dto.FindCustom;
import med.voll.api.domain.patient.dto.RegisterPatient;
import med.voll.api.domain.patient.dto.Update;

@RestController
@RequestMapping("/patients")
public class PatientController {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity registerPatient(@RequestBody @Valid RegisterPatient dados, UriComponentsBuilder uriBuilder) {
		var patient = new Patient(dados);
		patientRepository.save(patient);
		var uri = uriBuilder.path("patients/{id}").buildAndExpand(patient.getId()).toUri();
		return ResponseEntity.created(uri).body(new DataDetail(patient));
	}
	
	@GetMapping
	public ResponseEntity<Page<FindCustom>> findCustom(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
		return ResponseEntity.ok(patientRepository.findAllByAtivoTrue(paginacao).map(FindCustom::new));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity update(@RequestBody @Valid Update dados) {
		var patient = patientRepository.getReferenceById(dados.id());
		patient.updateData(dados);
		return ResponseEntity.ok(new DataDetail(patient));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity situation(@PathVariable Long id) {
		var patient = patientRepository.getReferenceById(id);
		patient.situation();
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity finById(@PathVariable Long id) {
		var patient = patientRepository.getReferenceById(id);
		return ResponseEntity.ok(new DataDetail(patient));
	}
}
