package com.autobots.automanager.controles;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.dto.EnderecoDTO;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoControle {
    @Autowired
    private EnderecoService service;

    @PutMapping("/{clienteId}")
    public Endereco atualizar(@PathVariable Long clienteId, @RequestBody @Valid EnderecoDTO dto ){
        return service.atualizar(clienteId, dto);
    }   
}
