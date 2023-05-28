package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jakarta.validation.Valid;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorRepository;
import med.voll.api.doctor.dto.FindCustom;
import med.voll.api.doctor.dto.RegisterDoctor;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@PostMapping
	@Transactional
	public void registerDoctor(@RequestBody @Valid RegisterDoctor dados) {
		doctorRepository.save(new Doctor(dados));
	}
	
	@GetMapping
	public Page<FindCustom> FindCustomList(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
		return doctorRepository.findAll(paginacao).map(FindCustom::new);
		
	}
}
