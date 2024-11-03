// AutomovelResource.java
package br.com.fiap.resources;

import br.com.fiap.model.bo.AutomovelBO;
import br.com.fiap.model.vo.Automovel;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.SQLException;
import java.util.List;

@Path("/automovel")
public class AutomovelResource {
    
    private AutomovelBO automovelBO = new AutomovelBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(Automovel automovel, @Context UriInfo uriInfo) {
        try {
            String resultado = automovelBO.cadastrarAutomovel(automovel);
            UriBuilder builder = uriInfo.getAbsolutePathBuilder();
            builder.path(automovel.getPlacaAutomovel());
            return Response.created(builder.build())
                          .entity(resultado)
                          .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                          .entity(e.getMessage())
                          .build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity("Erro ao cadastrar automóvel: " + e.getMessage())
                          .build();
        }
    }

    @PUT
    @Path("/{placa}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(Automovel automovel, @PathParam("placa") String placa) {
        try {
            automovel.setPlacaAutomovel(placa);
            String resultado = automovelBO.atualizarAutomovel(automovel);
            return Response.ok().entity(resultado).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity(e.getMessage())
                          .build();
        }
    }

    @DELETE
    @Path("/{placa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletar(@PathParam("placa") String placa) {
        try {
            String resultado = automovelBO.deletarAutomovel(placa);
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
            List<Automovel> automoveis = automovelBO.listarAutomoveis();
            return Response.ok(automoveis).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity(e.getMessage())
                          .build();
        }
    }
}