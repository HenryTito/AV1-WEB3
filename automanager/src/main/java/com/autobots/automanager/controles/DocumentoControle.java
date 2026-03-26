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

import com.autobots.automanager.dto.DocumentoDTO;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.service.DocumentoService;

@RestController
@RequestMapping("/documentos")
public class DocumentoControle {
    
    @Autowired
    private DocumentoService service;

    @PostMapping("/{clienteId}")
    public Documento criar(@PathVariable Long clienteId, @RequestBody @Valid DocumentoDTO dto){

        return service.criar(clienteId, dto);
    }


    @GetMapping
    public List<Documento> listar(){
        return service.listar();
    }


    @GetMapping("/{id}")
    public Documento buscar(@PathVariable Long id){
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Documento atualizar(@PathVariable Long id, @RequestBody @Valid DocumentoDTO dto){
            return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }




}
