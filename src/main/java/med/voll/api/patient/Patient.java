package med.voll.api.patient;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.patient.dto.RegisterPatient;
import med.voll.api.utils.Endereco;

@Table(name = "patients")
@Entity(name = "Patient")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Patient {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	
	@Embedded
	private Endereco endereco;
	
	public Patient (RegisterPatient dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.cpf = dados.cpf();
		this.endereco = new Endereco(dados.endereco());
		
	}
}
