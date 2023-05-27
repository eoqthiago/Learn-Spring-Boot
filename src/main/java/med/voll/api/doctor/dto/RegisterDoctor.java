package med.voll.api.doctor.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.dto.endereco.DadosEndereco;

public record RegisterDoctor(
		@NotBlank
		String nome,
		
		@NotBlank
		String email,
		
		@NotBlank
		String telefone,
		
		@NotBlank 
		@Pattern(regexp = "\\d{4,6}")
		String crm,
		
		@NotNull
		Especialidade especialidade,
		
		@NotNull
		@Valid
		DadosEndereco endereco
		
		) {
	
}
