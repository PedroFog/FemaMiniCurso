package com.fema.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fema.demo.model.Aluno;
import com.fema.demo.model.dto.AlunoDTO;
import com.fema.demo.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired private AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<?> listarAluno() {
		return ResponseEntity.ok().body(alunoService.listarAluno());
	}
	
	@GetMapping("/{nome}")
	public ResponseEntity<?> listarAlunoNome(@PathVariable String nome) {
		return ResponseEntity.ok().body(alunoService.listarAlunoNome(nome));
	}
	
	@GetMapping("/nome")
	public ResponseEntity<?> listarAlunoUnicoNome(@RequestParam(name = "nome") String nome) {
		return ResponseEntity.ok().body(alunoService.listarAlunoUnico(nome));
	}
	
	@PostMapping
	public ResponseEntity<?> salvarAluno(@RequestBody AlunoDTO alunoDTO) {
		return ResponseEntity.ok().body(alunoService.salvar(alunoDTO));
	}
	
	@PutMapping
	public ResponseEntity<?> editarAluno(@RequestBody Aluno aluno) {
		return ResponseEntity.ok().body(alunoService.editar(aluno));
	}
	
	
	@DeleteMapping
	public void removerAluno(@RequestParam(name = "id") Integer id) {
		alunoService.remover(id);
	}
	
}
