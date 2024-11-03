package br.com.fiap.resources;

import br.com.fiap.model.bo.OficinaBO;
import br.com.fiap.model.vo.Oficina;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.SQLException;
import java.util.List;

@Path("/oficina")
public class OficinaResource {
    
    private OficinaBO oficinaBO = new OficinaBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(Oficina oficina, @Context UriInfo uriInfo) {
        try {
            String resultado = oficinaBO.cadastrarOficina(oficina);
            UriBuilder builder = uriInfo.getAbsolutePathBuilder();
            builder.path(oficina.getEnderecoOficina());
            return Response.created(builder.build())
                          .entity(resultado)
                          .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                          .entity(e.getMessage())
                          .build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity("Erro ao cadastrar oficina: " + e.getMessage())
                          .build();
        }
    }

    @PUT
    @Path("/{endereco}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(Oficina oficina, @PathParam("endereco") String endereco) {
        try {
            oficina.setEnderecoOficina(endereco);
            String resultado = oficinaBO.atualizarOficina(oficina);
            return Response.ok().entity(resultado).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity(e.getMessage())
                          .build();
        }
    }

    @DELETE
    @Path("/{endereco}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletar(@PathParam("endereco") String endereco) {
        try {
            String resultado = oficinaBO.deletarOficina(endereco);
            return Response.ok().entity(resultado).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity(e.getMessage())
                          .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        try {
            List<Oficina> oficinas = oficinaBO.listarOficinas();
            return Response.ok(oficinas).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity(e.getMessage())
                          .build();
        }
    }
}