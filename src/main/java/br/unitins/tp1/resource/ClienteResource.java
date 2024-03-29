package br.unitins.tp1.resource;

import br.unitins.tp1.dto.ClienteDTO;
import br.unitins.tp1.service.ClienteService;
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
@Path("/clientes")
public class ClienteResource {
    
    @Inject
    public ClienteService clienteService;

    @GET
    @Path("/{id}") 
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(clienteService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(clienteService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(String nome){
        return Response.ok(clienteService.findByNome(nome)).build();
    }

    @GET
    @Path("/emailCliente/{emailCliente}")
    public Response findByEmailCliente(@PathParam("emailCliente") String email){
        return Response.ok(clienteService.findByEmailCliente(email)).build();
    }
    @POST
    public Response create(ClienteDTO dto) {
        return Response.status(Status.CREATED).entity(clienteService.create(dto)).build();
    }

    @PUT 
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ClienteDTO dto) {
        clienteService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE 
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        clienteService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
