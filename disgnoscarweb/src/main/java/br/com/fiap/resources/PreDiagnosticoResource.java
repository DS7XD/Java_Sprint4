// PreDiagnosticoResource.java
package br.com.fiap.resources;

import br.com.fiap.model.bo.PreDiagnosticoBO;
import br.com.fiap.model.vo.PreDiagnostico;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.SQLException;
import java.util.List;

@Path("/pre-diagnostico")
public class PreDiagnosticoResource {
    
    private PreDiagnosticoBO preDiagnosticoBO = new PreDiagnosticoBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(PreDiagnostico preDiagnostico, @Context UriInfo uriInfo) {
        try {
            String resultado = preDiagnosticoBO.cadastrarPreDiagnostico(preDiagnostico);
            UriBuilder builder = uriInfo.getAbsolutePathBuilder();
            builder.path(preDiagnostico.getIdPreDiagnostico());
            return Response .created(builder.build())
                          .entity(resultado)
                          .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                          .entity(e.getMessage())
                          .build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity("Erro ao cadastrar pré-diagnóstico: " + e.getMessage())
                          .build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(PreDiagnostico preDiagnostico, @PathParam("id") String id) {
        try {
            preDiagnostico.setIdPreDiagnostico(id);
            String resultado = preDiagnosticoBO.atualizarPreDiagnostico(preDiagnostico);
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
            String resultado = preDiagnosticoBO.deletarPreDiagnostico(id);
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
            List<PreDiagnostico> preDiagnosticos = preDiagnosticoBO.listarPreDiagnosticos();
            return Response.ok(preDiagnosticos).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity(e.getMessage())
                          .build();
        }
    }
}