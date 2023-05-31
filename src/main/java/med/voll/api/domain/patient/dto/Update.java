package med.voll.api.domain.patient.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.dto.endereco.DadosEndereco;

public record Update(
		@NotNull
		Long id,
		String nome,
		String telefone,
		DadosEndereco endereco
		) {

}
