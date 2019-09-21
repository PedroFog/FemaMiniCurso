package com.fema.demo.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fema.demo.model.Aluno;
import com.fema.demo.model.dto.AlunoDTO;
import com.fema.demo.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired private AlunoRepository alunoRepository;
	
	public List<Aluno> listarAluno() {
		return alunoRepository.findAll();
	}
	
	public List<Aluno> listarAlunoNome(String nome) {
		return alunoRepository.findByNomeContaining(nome);
	}
	
	public Aluno listarAlunoUnico(String nome) {
		return alunoRepository.findByNome(nome);
	}

	public Aluno salvar(AlunoDTO aluno) {
		Aluno alunoSalvar = new Aluno();
		
		BeanUtils.copyProperties(aluno, alunoSalvar);
		return alunoRepository.save(alunoSalvar);
	}

	public Aluno editar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public void remover(Integer id) {
		alunoRepository.deleteById(id);
	}

}
