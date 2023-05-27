package med.voll.api.patient.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.dto.endereco.DadosEndereco;

public record RegisterPatient(
		@NotBlank
		String nome,
		
		@NotBlank
		String email,
		
		@NotBlank
		String telefone,
		
		@NotBlank
		@Pattern(regexp = "\\d{11}")
		String cpf,
		
		@NotNull 
		@Valid
		DadosEndereco endereco
		) {

}
