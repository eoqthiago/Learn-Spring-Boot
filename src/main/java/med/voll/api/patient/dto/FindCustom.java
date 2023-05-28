package med.voll.api.patient.dto;

import med.voll.api.patient.Patient;

public record FindCustom(String nome, String email, String cpf) {
	
	public FindCustom(Patient patient) {
		this(patient.getNome(), patient.getEmail(), patient.getCpf());
	}
}
