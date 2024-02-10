package com.example.demo.model;

import com.example.demo.alunoDTO.AlunoRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class AlunoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "Email é obrigatório")
	private String email;
	
	public AlunoModel() {
		
	}

	public AlunoModel(AlunoRequestDTO alunoRequestDTO) {
		this.nome = alunoRequestDTO.nome();
		this.email = alunoRequestDTO.email();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
