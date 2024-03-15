package br.unitins.tp1.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.unitins.tp1.dto.ProdutoDTO;
import br.unitins.tp1.service.ProdutoService;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    public ProdutoService produtoService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(produtoService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(produtoService.findAll()).build();
    }

    @GET
    @Path("/search/marca/{marca}")
    public Response findByMarca(@PathParam("marca") String marca){
        return Response.ok(produtoService.findByMarca(marca)).build();
    }

    @GET
    @Path("/search/modelo/{modelo}")
    public Response findByModelo(@PathParam("modelo") String modelo){
        return Response.ok(produtoService.findByModelo(modelo)).build();
    }

    @POST
    public Response create(ProdutoDTO dto){
        return Response.status(Status.CREATED).entity(produtoService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ProdutoDTO dto){
        produtoService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        produtoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
