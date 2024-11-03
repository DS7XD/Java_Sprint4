// PecaResource.java
package br.com.fiap.resources;

import br.com.fiap.model.bo.PecaBO;
import br.com.fiap.model.vo.Peca;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.SQLException;
import java.util.List;

@Path("/peca")
public class PecaResource {
    
    private PecaBO pecaBO = new PecaBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(Peca peca, @Context UriInfo uriInfo) {
        try {
            String resultado = pecaBO.cadastrarPeca(peca);
            UriBuilder builder = uriInfo.get BaseUriBuilder();
            builder.path(PecaResource.class)
                   .path(PecaResource.class, "cadastrar")
                   .build(peca.getIdPeca());
            return Response.created(builder.build())
                          .entity(resultado)
                          .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                          .entity(e.getMessage())
                          .build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity("Erro ao cadastrar peça: " + e.getMessage())
                          .build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(Peca peca, @PathParam("id") String id) {
        try {
            peca.setIdPeca(id);
            String resultado = pecaBO.atualizarPeca(peca);
            return Response.ok().entity(resultado).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity(e.getMessage())
                          .build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletar(@PathParam("id") String id) {
        try {
            String resultado = pecaBO.deletarPeca(id);
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
            List<Peca> pecas = pecaBO.listarPecas();
            return Response.ok(pecas).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity(e.getMessage())
                          .build();
        }
    }
}