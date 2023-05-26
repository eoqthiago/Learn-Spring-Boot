package med.voll.api.dto.doctor;

import med.voll.api.dto.endereco.DadosEndereco;

public record RegisterDoctor(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {
	
}
