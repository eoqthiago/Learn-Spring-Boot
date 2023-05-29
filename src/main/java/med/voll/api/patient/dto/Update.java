package med.voll.api.patient.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.endereco.DadosEndereco;

public record Update(
		@NotNull
		Long id,
		String nome,
		String telefone,
		DadosEndereco endereco
		) {

}
