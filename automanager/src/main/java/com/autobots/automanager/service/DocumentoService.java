package com.autobots.automanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.dto.DocumentoDTO;
import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.DocumentoRepositorio;

@Service
public class DocumentoService {
    
    @Autowired
    private DocumentoRepositorio repositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public Documento criar(Long clienteId, DocumentoDTO dto){

        Cliente cliente = clienteRepositorio.findById(clienteId)
        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));


         Documento doc = new Documento();
         doc.setTipo(dto.getTipo());
        doc.setNumero(dto.getNumero());
    

        doc.setCliente(cliente);
        return repositorio.save(doc);

    }

    public List<Documento> listar(){
        return repositorio.findAll();
    }

    public Documento buscar(Long id){
        return repositorio.findById(id)
        .orElseThrow(() -> new RuntimeException("Documento não encontrado"));
    }

    public Documento atualizar(Long id, DocumentoDTO dto){
        Documento doc = buscar(id);
        doc.setTipo(dto.getTipo());
        doc.setNumero(dto.getNumero());
        return repositorio.save(doc);
    }

    public void deletar(Long id){
        repositorio.deleteById(id);
    }



}
