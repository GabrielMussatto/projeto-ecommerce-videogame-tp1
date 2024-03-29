package br.unitins.tp1.resource;

import br.unitins.tp1.dto.FornecedorDTO;
import br.unitins.tp1.service.FornecedorService;
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

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/fornecedores")
public class FornecedorResource {
    
    @Inject
    public FornecedorService fornecedorService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        return Response.ok(fornecedorService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(fornecedorService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome){
        return Response.ok(fornecedorService.findByNome(nome)).build();
    }

    @GET
    @Path("/search/emailfornecedor/{emailfornecedor}")
    public Response findByEmailFornecedor(@PathParam("emailfornecedor") String email){
        return Response.ok(fornecedorService.findByEmailFornecedor(email)).build();
    }

    @POST
    public Response create(FornecedorDTO dto) {
        return Response.status(Status.CREATED).entity(fornecedorService.create(dto)).build();        
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, FornecedorDTO dto) {
        fornecedorService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE 
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        fornecedorService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
