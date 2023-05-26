package med.voll.api.dto.patient;

import med.voll.api.dto.endereco.DadosEndereco;

public record RegisterPatient(String nome, String email, String telefone, String cpf, DadosEndereco endereco) {

}
