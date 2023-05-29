package med.voll.api.patient.dto;


import med.voll.api.doctor.dto.Especialidade;
import med.voll.api.patient.Patient;
import med.voll.api.utils.Endereco;

public record DataDetail(Long id, String nome, String email, String telefone, String cpf, Endereco endereco) {
	public DataDetail(Patient patient) {
		this(patient.getId(), patient.getNome(), patient.getEmail(), patient.getTelefone(), patient.getCpf(), patient.getEndereco());
	}
}
