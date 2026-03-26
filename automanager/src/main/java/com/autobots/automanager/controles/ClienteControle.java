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

import com.autobots.automanager.dto.ClienteDTO;
import com.autobots.automanager.entidades.Cliente;


import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteControle {
	
	@Autowired
	private ClienteService service;
	



	@PostMapping
	public Cliente criar(@RequestBody @Valid ClienteDTO dto){
		return service.criar(dto);
	}

	@GetMapping
	public List<Cliente> listar(){
		return service.listar();
	}

	@GetMapping("/{id}")
	public Cliente buscar(@PathVariable Long id){
		return service.buscarPorId(id);
	}

	@PutMapping("/{id}")
	public Cliente atualizar(@PathVariable Long id, @RequestBody @Valid ClienteDTO dto){
		return service.atualizar(id, dto);
	}
	

	@GetMapping("/saul")
	public String saul(){
    return "Did you know you have rights? The Constitution says you do and so do I! Better Call Saul!";
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id){
		service.deletar(id);
	}

	

}
