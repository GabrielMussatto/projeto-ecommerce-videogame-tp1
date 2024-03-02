package br.unitins.tp1.resource;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import br.unitins.tp1.model.Produto;
import br.unitins.tp1.service.ProdutoService;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @jakarta.inject.Inject
    ProdutoService produtoService;

    @GET
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Produto buscarPorId(@PathParam("id") Long id) {
        return produtoService.buscarPorId(id);
    }

    @POST
    @Transactional
    public Response criarProduto(Produto produto) {
        produtoService.salvar(produto);
        return Response.status(Response.Status.CREATED).entity(produto).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarProduto(@PathParam("id") Long id, Produto produto) {
        Produto produtoExistente = produtoService.buscarPorId(id);

        if (produtoExistente == null) {
            throw new WebApplicationException("Produto com ID " + id + " não encontrado.", Response.Status.NOT_FOUND);
        }

        produtoExistente.setNome(produto.getNome());
        produtoExistente.setDescricao(produto.getDescricao());
        produtoExistente.setPreco(produto.getPreco());

        produtoService.atualizar(produtoExistente);

        return Response.status(Response.Status.OK).entity(produtoExistente).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarProduto(@PathParam("id") Long id) {
        Produto produtoExistente = produtoService.buscarPorId(id);

        if (produtoExistente == null) {
            throw new WebApplicationException("Produto com ID " + id + " não encontrado.", Response.Status.NOT_FOUND);
        }

        produtoService.deletar(id);

        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
