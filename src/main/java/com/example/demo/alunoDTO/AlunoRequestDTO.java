package com.example.demo.alunoDTO;

import jakarta.validation.constraints.NotBlank;

public record AlunoRequestDTO(
		
		String id,
		
		@NotBlank
		String nome, 
		
		@NotBlank
		String email) {

}
