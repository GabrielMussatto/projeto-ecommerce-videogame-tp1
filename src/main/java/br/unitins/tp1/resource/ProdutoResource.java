package br.unitins.tp1.resource;

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

import java.util.List;

import br.unitins.tp1.dto.ProdutoDTO;
import br.unitins.tp1.dto.ProdutoResponseDTO;
import br.unitins.tp1.model.Produto;
import br.unitins.tp1.repository.ProdutoRepository;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    ProdutoRepository produtoRepository;

    @GET
    @Path("/{id}")
    public ProdutoResponseDTO findById(@PathParam("id") Long id) {
        return ProdutoResponseDTO.valueOf(produtoRepository.findById(id));
    }

    @GET
    public List<ProdutoResponseDTO> findAll() {
        return produtoRepository.listAll().stream().map(produto -> ProdutoResponseDTO.valueOf(produto)).toList();
    }

    @POST
    @Transactional
    public ProdutoResponseDTO create(ProdutoDTO dto){
        Produto produto = new Produto();
        produto.setMarca(dto.marca());
        produto.setModelo(dto.modelo());
        produto.setPreco(dto.preco());
        produto.setCor(dto.cor());
        produtoRepository.persist(produto);
        return ProdutoResponseDTO.valueOf(produto);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void update(@PathParam("id") Long id, ProdutoDTO dto){
        Produto produtoBanco = produtoRepository.findById(id);

        produtoBanco.setMarca(dto.marca());
        produtoBanco.setModelo(dto.modelo());
        produtoBanco.setPreco(dto.preco());
        produtoBanco.setCor(dto.cor());
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id){
        produtoRepository.deleteById(id);
    }
}
