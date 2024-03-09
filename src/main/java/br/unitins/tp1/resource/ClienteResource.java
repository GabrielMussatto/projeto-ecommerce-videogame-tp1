package br.unitins.tp1.resource;

import java.util.List;

import br.unitins.tp1.dto.ClienteDTO;
import br.unitins.tp1.dto.ClienteResponseDTO;
import br.unitins.tp1.model.Cliente;
import br.unitins.tp1.repository.ClienteRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/clientes")
public class ClienteResource {
    
    @Inject
    public ClienteRepository clienteRepository;

    @GET
    @Path("/{id}") 
    public ClienteResponseDTO findById(@PathParam("id") Long id) {
        return ClienteResponseDTO.valueOf(clienteRepository.findById(id));
    }

    @GET
    public List<ClienteResponseDTO> findAll() {
        return clienteRepository.listAll().stream().map(cliente -> ClienteResponseDTO.valueOf(cliente)).toList();
    }

    @POST
    @Transactional 
    public ClienteResponseDTO create(ClienteDTO dto) {
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

    @PUT
    @Transactional 
    @Path("/{id}")
    public void update(@PathParam("id") Long id, ClienteDTO dto) {
        Cliente clienteBanco = clienteRepository.findById(id);

        clienteBanco.setNome(dto.nome());
        clienteBanco.setCpf(dto.cpf());
        clienteBanco.setEmail(dto.email());
        clienteBanco.setTelefone(dto.telefone());
        clienteBanco.setEndereco(dto.endereco());
        clienteBanco.setDataNascimento(dto.dataNascimento());
    }

    @DELETE
    @Transactional 
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        clienteRepository.deleteById(id);
    }
}
