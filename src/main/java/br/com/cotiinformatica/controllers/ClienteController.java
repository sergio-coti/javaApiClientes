package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.ClienteRequestDto;
import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.repositories.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	/*
	 * Serviço para cadastro de cliente
	 */
	@PostMapping
	public String post(@RequestBody ClienteRequestDto dto) {
		
		//instanciando o objeto Cliente
		var cliente = new Cliente();
		
		//capturar os dados do cliente
		cliente.setId(UUID.randomUUID());
		cliente.setNome(dto.getNome());
		cliente.setEmail(dto.getEmail());
		cliente.setTelefone(dto.getTelefone());
		
		//gravar no banco de dados
		var clienteRepository = new ClienteRepository();
		clienteRepository.create(cliente);
		
		//retornando mensagem de sucesso..
		return "Cliente cadastrado com sucesso.";
	}
	
	/*
	 * Serviço para consulta de clientes
	 */
	@GetMapping
	public List<Cliente> getAll() {
		
		//retornar todos os clientes obtidos do banco de dados
		var clienteRepository = new ClienteRepository();
		return clienteRepository.findAll();
	}
	
	/*
	 * Serviço para consultar 1 cliente através do ID
	 */
	@GetMapping("{id}")
	public Cliente getById(@PathVariable UUID id) {
		
		//retornar 1 cliente baseado no ID
		var clienteRepository = new ClienteRepository();
		return clienteRepository.findById(id);
	}
	
	/*
	 * Serviço para atualizar o cliente
	 */
	@PutMapping("{id}")
	public String put(@PathVariable UUID id, @RequestBody ClienteRequestDto dto) {
		
		//instanciando um objeto da classe 'Cliente'
		var cliente = new Cliente();
		
		//capturar os dados do cliente
		cliente.setId(id);
		cliente.setNome(dto.getNome());
		cliente.setEmail(dto.getEmail());
		cliente.setTelefone(dto.getTelefone());
		
		//atualizando o cliente no banco de dados
		var clienteRepository = new ClienteRepository();
		clienteRepository.update(cliente);
		
		return "Cliente atualizado com sucesso.";
	}
	
	/*
	 * Serviço para excluir o cliente
	 */
	@DeleteMapping("{id}")
	public String delete(@PathVariable UUID id) {
		
		//excluindo o cliente no banco de dados
		var clienteRepository = new ClienteRepository();
		clienteRepository.delete(id);
		
		return "Cliente excluído com sucesso.";
	}
	
}










