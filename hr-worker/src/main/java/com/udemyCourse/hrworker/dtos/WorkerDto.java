package com.udemyCourse.hrworker.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkerDto {
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
