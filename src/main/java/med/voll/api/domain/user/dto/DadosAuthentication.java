package med.voll.api.domain.user.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAuthentication(
		@NotBlank
		String login, 
		@NotBlank
		String password
		) {
	
}
