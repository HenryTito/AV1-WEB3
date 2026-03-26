package com.autobots.automanager.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;



@Data
public class EnderecoDTO {
    

    private String estado;

    private String cidade;

    private String bairro;

    @NotBlank(message = "Campo cidade não pode ficar vazio")
    


    @NotBlank(message = "Campo número não pode ficar vazio")
    private String numero;

    @NotBlank(message = "Campo Rua não pode ficar vazio")
    private String rua;

     private String codigoPostal;

      private String informacoesAdicionais;


}
