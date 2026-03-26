package com.autobots.automanager.service;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.dto.ClienteDTO;
import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.entidades.Telefone;


@Service
public class ClienteService {
    @Autowired
    private ClienteRepositorio repositorio;



    public Cliente criar(ClienteDTO dto){

        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setNomeSocial(dto.getNomeSocial());
        cliente.setDataNascimento(dto.getDataNascimento());
        cliente.setDataCadastro(new Date());

        // documentos
        if(dto.getDocumentos() != null){
            dto.getDocumentos().forEach(docDTO -> {
                Documento doc = new Documento();
                doc.setTipo(docDTO.getTipo());
                doc.setNumero(docDTO.getNumero());

                doc.setCliente(cliente);
                cliente.getDocumentos().add(doc);
            });
        }

        //endereco

        if(dto.getEndereco() != null){
            Endereco end = new Endereco();

            end.setEstado(dto.getEndereco().getEstado());
            end.setCidade(dto.getEndereco().getCidade());
            end.setBairro(dto.getEndereco().getBairro());
            end.setRua(dto.getEndereco().getRua());
            end.setNumero(dto.getEndereco().getNumero());
            end.setCodigoPostal(dto.getEndereco().getCodigoPostal());
            end.setInformacoesAdicionais(dto.getEndereco().getInformacoesAdicionais());

            cliente.setEndereco(end);
        }

        // telefone

        if(dto.getTelefones() != null) {
            dto.getTelefones().forEach(telDTO -> {
                Telefone tel = new Telefone();

                tel.setDdd(telDTO.getDdd());
                tel.setNumero(telDTO.getNumero());
                tel.setCliente(cliente);
                cliente.getTelefones().add(tel);

            });
        }





        return repositorio.save(cliente);







    }

    public List<Cliente> listar(){
        return repositorio.findAll();
    }

    public Cliente buscarPorId(Long id){
        return repositorio.findById(id)
        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente atualizar(Long id, ClienteDTO dto){
       Cliente cliente = buscarPorId(id);

    
        cliente.setNome(dto.getNome());
        cliente.setNomeSocial(dto.getNomeSocial());
        cliente.setDataNascimento(dto.getDataNascimento());

  
    cliente.getDocumentos().clear();

    if (dto.getDocumentos() != null) {
        dto.getDocumentos().forEach(docDTO -> {
            Documento doc = new Documento();

            doc.setTipo(docDTO.getTipo());
            doc.setNumero(docDTO.getNumero());
            doc.setCliente(cliente);

            cliente.getDocumentos().add(doc);
        });
    }

    cliente.getTelefones().clear();

    if (dto.getTelefones() != null) {
        dto.getTelefones().forEach(telDTO -> {
            Telefone tel = new Telefone();

            tel.setDdd(telDTO.getDdd());
            tel.setNumero(telDTO.getNumero());
            tel.setCliente(cliente);

            cliente.getTelefones().add(tel);
        });
    }

    if (dto.getEndereco() != null) {

        Endereco end = new Endereco();

        end.setEstado(dto.getEndereco().getEstado());
        end.setCidade(dto.getEndereco().getCidade());
        end.setBairro(dto.getEndereco().getBairro());
        end.setRua(dto.getEndereco().getRua());
        end.setNumero(dto.getEndereco().getNumero());
        end.setCodigoPostal(dto.getEndereco().getCodigoPostal());
        end.setInformacoesAdicionais(dto.getEndereco().getInformacoesAdicionais());

        cliente.setEndereco(end);
    }
         
        return repositorio.save(cliente);
    }


    public void deletar(Long id){
        Cliente cliente = buscarPorId(id);
        repositorio.delete(cliente);
    }




}
