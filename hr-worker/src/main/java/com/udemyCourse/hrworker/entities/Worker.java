package com.udemyCourse.hrworker.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_worker")
public class Worker implements Serializable{
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double dailyIncome;
	private String cargo;
	private String empresa;
	private String cnpj;
	private String email;
	private String primeiroNome;
	private String ultimoNome;
	private String cidade;
	private String pais;
	private String cep;

}
