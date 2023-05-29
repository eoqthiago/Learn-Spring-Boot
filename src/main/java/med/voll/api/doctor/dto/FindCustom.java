package med.voll.api.doctor.dto;

import med.voll.api.doctor.Doctor;

public record FindCustom(Long id, String nome, String email, String crm, Especialidade especialidade, Boolean ativo) {
	public FindCustom(Doctor doctor) {
		this(doctor.getId(),doctor.getNome(), doctor.getEmail(), doctor.getCrm(), doctor.getEspecialidade(), doctor.getAtivo());
	}
}
