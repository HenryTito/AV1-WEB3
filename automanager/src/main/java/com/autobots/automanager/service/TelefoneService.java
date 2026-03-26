package com.autobots.automanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.dto.TelefoneDTO;
import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.TelefoneRepositorio;

@Service
public class TelefoneService {
    @Autowired
    private TelefoneRepositorio repositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;



    public Telefone criar(Long clienteId, TelefoneDTO dto){
        Cliente cliente = clienteRepositorio.findById(clienteId)
        .orElseThrow(() -> new RuntimeException("Cliente Não encontrado"));


        Telefone tel = new Telefone(); 
        tel.setDdd(dto.getDdd());
        tel.setNumero(dto.getNumero());
        tel.setCliente(cliente);
        return repositorio.save(tel);
    }

    public List<Telefone> listar(){
        return repositorio.findAll();
    }

    public Telefone buscar(Long id){
        return repositorio.findById(id)
        .orElseThrow(()-> new RuntimeException("Telefone não encontrado"));
    }


    public Telefone atualizar(Long id, TelefoneDTO dto){
        Telefone tel = buscar(id);
        tel.setDdd(dto.getDdd());
        tel.setNumero(dto.getNumero());

        return repositorio.save(tel);

    }

    public void deletar(Long id){
        repositorio.deleteById(id);
    }


}
