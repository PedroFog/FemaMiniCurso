package com.fema.demo.model.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoDTO {

	private String nome;
	private String cpf;
	private LocalDate nascimento;
	private Integer ano;
	
}
