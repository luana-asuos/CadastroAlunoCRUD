package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.alunoDTO.AlunoRequestDTO;
import com.example.demo.model.AlunoModel;
import com.example.demo.repository.AlunoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public ResponseEntity getAllAlunos() {
		var allAlunos = alunoRepository.findAll();
		return ResponseEntity.ok(allAlunos);
	}
	
	@PostMapping
	public ResponseEntity registerAluno(@RequestBody @Valid AlunoRequestDTO data) {
		AlunoModel newAluno = new AlunoModel(data);
		alunoRepository.save(newAluno);
		return ResponseEntity.ok().build();
	}

	@PutMapping
	@Transactional
	public ResponseEntity updateAluno(@RequestBody @Valid AlunoRequestDTO data) {
		Optional<AlunoModel> optionalAlunoModel = alunoRepository.findById(data.id());
		 if (optionalAlunoModel.isPresent()) {
	            AlunoModel alunoModel = optionalAlunoModel.get();
	            alunoModel.setNome(data.nome());
	            alunoModel.setEmail(data.email());
	            return ResponseEntity.ok(alunoModel);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") String id) {
		
		alunoRepository.deleteById(id);

		return ResponseEntity.ok().build();
	}
	
	
}
