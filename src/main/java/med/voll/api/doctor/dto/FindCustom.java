package med.voll.api.doctor.dto;

import med.voll.api.doctor.Doctor;

public record FindCustom(String nome, String email, String crm, Especialidade especialidade) {
	public FindCustom(Doctor doctor) {
		this(doctor.getNome(), doctor.getEmail(), doctor.getCrm(), doctor.getEspecialidade());
	}
}
