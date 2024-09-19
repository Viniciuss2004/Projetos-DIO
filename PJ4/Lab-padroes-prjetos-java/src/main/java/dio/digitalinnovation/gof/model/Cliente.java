package dio.digitalinnovation.gof.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@ManyToOne
	private dio.digitalinnovation.gof.model.Endereco endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public dio.digitalinnovation.gof.model.Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(dio.digitalinnovation.gof.model.Endereco endereco) {
		this.endereco = endereco;
	}

}