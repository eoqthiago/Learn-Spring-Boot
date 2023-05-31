package med.voll.api.domain.patient.dto;


import med.voll.api.domain.doctor.dto.Especialidade;
import med.voll.api.domain.patient.Patient;
import med.voll.api.utils.Endereco;

public record DataDetail(Long id, String nome, String email, String telefone, String cpf, Endereco endereco) {
	public DataDetail(Patient patient) {
		this(patient.getId(), patient.getNome(), patient.getEmail(), patient.getTelefone(), patient.getCpf(), patient.getEndereco());
	}
}
