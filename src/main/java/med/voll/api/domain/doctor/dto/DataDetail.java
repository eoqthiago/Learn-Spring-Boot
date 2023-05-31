package med.voll.api.domain.doctor.dto;

import med.voll.api.domain.doctor.Doctor;
import med.voll.api.utils.Endereco;

public record DataDetail(Long id, String nome, String email, String telefone, String crm, Especialidade especialidade, Endereco endereco) {

	public DataDetail(Doctor doctor) {
		this(doctor.getId(), doctor.getNome(), doctor.getEmail(), doctor.getTelefone(), doctor.getCrm(), doctor.getEspecialidade(), doctor.getEndereco());
	}
}
