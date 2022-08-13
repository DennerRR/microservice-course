package com.udemyCourse.hrworker.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.*;

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


	public Worker() {
		
	}

	public Worker(Long id, String name, Double dailyIncome, String cargo, String empresa, String cnpj) {
		this.id = id;
		this.name = name;
		this.dailyIncome = dailyIncome;
		this.cargo = cargo;
		this.empresa = empresa;
		this.cnpj = cnpj ;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDailyIncome() {
		return dailyIncome;
	}

	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dailyIncome, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		return Objects.equals(dailyIncome, other.dailyIncome) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}
	
	
}
