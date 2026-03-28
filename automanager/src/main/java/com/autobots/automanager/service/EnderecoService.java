package com.autobots.automanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.dto.EnderecoDTO;
import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@Service
public class EnderecoService {
    
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public Endereco atualizar(Long clienteId, EnderecoDTO dto){
        Cliente cliente = clienteRepositorio.findById(clienteId)
        .orElseThrow(()-> new RuntimeException("Cliente Não encontrado"));

        Endereco end = cliente.getEndereco();

         if(end == null){
            end = new Endereco();
            cliente.setEndereco(end);
        }

        end.setEstado(dto.getEstado());
        end.setCidade(dto.getCidade());
        end.setBairro(dto.getBairro());
        end.setRua(dto.getRua());
        end.setNumero(dto.getNumero());
        end.setCodigoPostal(dto.getCodigoPostal());
        end.setInformacoesAdicionais(dto.getInformacoesAdicionais());

        cliente.setEndereco(end);
        clienteRepositorio.save(cliente);


        return end;
    }




}
