package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.ClienteDTO;
import br.unitins.tp1.dto.ClienteResponseDTO;
import br.unitins.tp1.model.Cliente;
import br.unitins.tp1.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {
    
    @Inject
    public ClienteRepository clienteRepository;

    @Override
    @Transactional
    public ClienteResponseDTO create(@Valid ClienteDTO dto){
        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());
        cliente.setCpf(dto.cpf());
        cliente.setEmail(dto.email());
        cliente.setTelefone(dto.telefone());
        cliente.setEndereco(dto.endereco());
        cliente.setDataNascimento(dto.dataNascimento());

        clienteRepository.persist(cliente);
        return ClienteResponseDTO.valueOf(cliente);
    }

    @Override
    @Transactional
    public void update(Long id, ClienteDTO dto){
        Cliente clienteBanco = clienteRepository.findById(id);

        clienteBanco.setNome(dto.nome());
        clienteBanco.setCpf(dto.cpf());
        clienteBanco.setEmail(dto.email());
        clienteBanco.setTelefone(dto.telefone());
        clienteBanco.setEndereco(dto.endereco());
        clienteBanco.setDataNascimento(dto.dataNascimento());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public ClienteResponseDTO findById(Long id){
        return ClienteResponseDTO.valueOf(clienteRepository.findById(id));
    }

    @Override
    public List<ClienteResponseDTO> findAll(){
        return clienteRepository
                .listAll()
                .stream()
                .map(cliente -> ClienteResponseDTO.valueOf(cliente))
                .toList();
    }

    @Override
    public List<ClienteResponseDTO> findByNome(String nome){
        return clienteRepository.findByNome(nome)
                .stream()  
                .map(cliente -> ClienteResponseDTO.valueOf(cliente))
                .toList();
    }

    @Override
    public List<ClienteResponseDTO> findByEmailCliente(String email){
        return clienteRepository.findByEmailCliente(email)
                .stream()
                .map(cliente -> ClienteResponseDTO.valueOf(cliente))
                .toList();
    }
}
