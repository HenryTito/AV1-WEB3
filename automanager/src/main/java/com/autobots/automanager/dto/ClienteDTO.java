package com.autobots.automanager.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class ClienteDTO {

    @NotBlank(message = "Não é permitido colocar o nome em branco")
    private String nome;

    private String nomeSocial;


    @NotNull(message = "Data nascimento obrigatória!")
    private Date dataNascimento;

    @Valid
    private List<DocumentoDTO> documentos;

    @Valid
    private EnderecoDTO endereco;

    @Valid
    private List<TelefoneDTO> telefones;



}
