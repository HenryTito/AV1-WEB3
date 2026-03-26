package com.autobots.automanager.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;


@Data
public class DocumentoDTO {
   
   
    @NotBlank(message = "Tipo do documento é obrigatório!")
    private String tipo;

    @NotBlank(message = "Número obrigatório")
    private String numero;


}
