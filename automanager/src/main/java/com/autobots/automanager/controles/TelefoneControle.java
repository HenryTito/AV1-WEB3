package com.autobots.automanager.controles;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.dto.TelefoneDTO;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.service.TelefoneService;

@RestController
@RequestMapping("/telefones")
public class TelefoneControle {
    

    @Autowired
    private TelefoneService service;

    @PostMapping("/{clienteId}")
    public Telefone criar(@PathVariable Long clienteId, @RequestBody @Valid TelefoneDTO dto){
        return service.criar(clienteId, dto);
    }

    @GetMapping
    public List<Telefone> listar(){
        return service.listar();
    }


    @GetMapping("/{id}")
    public Telefone buscar(@PathVariable Long id){
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Telefone atualizar(@PathVariable Long id, @RequestBody @Valid TelefoneDTO dto){
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
