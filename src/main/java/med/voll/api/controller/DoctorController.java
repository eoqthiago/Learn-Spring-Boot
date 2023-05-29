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
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorRepository;
import med.voll.api.doctor.dto.DataDetail;
import med.voll.api.doctor.dto.FindCustom;
import med.voll.api.doctor.dto.RegisterDoctor;
import med.voll.api.doctor.dto.Update;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity registerDoctor(@RequestBody @Valid RegisterDoctor dados, UriComponentsBuilder uriBuilder) {
		var doctor = new Doctor(dados);
		doctorRepository.save(doctor);
		var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DataDetail(doctor));
	}
	
	@GetMapping
	public ResponseEntity<Page<FindCustom>> findCustomList(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
		return ResponseEntity.ok(doctorRepository.findAllByAtivoTrue(paginacao).map(FindCustom::new));
		
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity update (@RequestBody @Valid Update dados) {
		var doctor = doctorRepository.getReferenceById(dados.id());
		doctor.updateData(dados);
		return ResponseEntity.ok(new DataDetail(doctor));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity situation(@PathVariable Long id) {
		var doctor = doctorRepository.getReferenceById(id);
		doctor.situation();
		
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable Long id) {
		var doctor = doctorRepository.getReferenceById(id);
		return ResponseEntity.ok(new DataDetail(doctor));
	}
}
