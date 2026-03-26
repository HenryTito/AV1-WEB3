package com.autobots.automanager.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;



@Data
public class TelefoneDTO {
    @NotBlank(message = "Para que haja telefone, deve conter DDD!")
    private String ddd;

    @NotBlank(message= "Campo número não pode ficar vazio")
    private String numero;
}
