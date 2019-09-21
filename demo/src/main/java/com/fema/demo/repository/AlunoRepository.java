package com.fema.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fema.demo.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

	List<Aluno> findByNomeContaining(String nome);

	Aluno findByNome(String nome);
	
	
}
