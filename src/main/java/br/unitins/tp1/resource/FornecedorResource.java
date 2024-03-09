package br.unitins.tp1.resource;

import java.util.List;

import br.unitins.tp1.dto.FornecedorDTO;
import br.unitins.tp1.dto.FornecedorResponseDTO;
import br.unitins.tp1.model.Fornecedor;
import br.unitins.tp1.repository.FornecedorRepository;
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
@Path("/fornecedores")
public class FornecedorResource {
    
    @Inject
    public FornecedorRepository fornecedorRepository;

    @GET
    @Path("/{id}")
    public FornecedorResponseDTO findById(@PathParam("id") Long id){
        return FornecedorResponseDTO.valueOf(fornecedorRepository.findById(id));
    }

    @GET
    public List<FornecedorResponseDTO> findAll() {
        return fornecedorRepository.listAll().stream().map(fornecedor -> FornecedorResponseDTO.valueOf(fornecedor)).toList();
    }

    @POST
    @Transactional 
    public FornecedorResponseDTO create(FornecedorDTO dto) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(dto.nome());
        fornecedor.setTelefone(dto.telefone());
        fornecedor.setLocalLojaFornecedor(dto.localLojaFornecedor());
        fornecedor.setEmail(dto.email());
        fornecedor.setCnpj(dto.cnpj());
        
        fornecedorRepository.persist(fornecedor);
        return FornecedorResponseDTO.valueOf(fornecedor);
    }

    @PUT
    @Transactional 
    @Path("/{id}")
    public void update(@PathParam("id") Long id, FornecedorDTO dto) {
        Fornecedor fornecedorBanco = fornecedorRepository.findById(id);

        fornecedorBanco.setNome(dto.nome());
        fornecedorBanco.setTelefone(dto.telefone());
        fornecedorBanco.setLocalLojaFornecedor(dto.localLojaFornecedor());
        fornecedorBanco.setEmail(dto.email());
        fornecedorBanco.setCnpj(dto.cnpj());
    }

    @DELETE
    @Transactional 
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        fornecedorRepository.deleteById(id);
    }
}
