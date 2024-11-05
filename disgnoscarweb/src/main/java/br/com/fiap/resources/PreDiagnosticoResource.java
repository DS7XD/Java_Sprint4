package br.com.fiap.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.model.bo.PreDiagnosticoBO;
import br.com.fiap.model.vo.PreDiagnosticoVO;

@Path("/pre_diagnosticos")
public class PreDiagnosticoResource {

    private PreDiagnosticoBO preDiagnosticoBO;

    public PreDiagnosticoResource() throws ClassNotFoundException, SQLException {
        preDiagnosticoBO = new PreDiagnosticoBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarPreDiagnostico(PreDiagnosticoVO preDiagnostico, @Context UriInfo uriInfo) throws SQLException {
        if (preDiagnostico.getIdPreDiagnostico() == null || preDiagnostico.getDiagnostico() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("ID e Diagnóstico são obrigatórios.").build();
        }

        preDiagnosticoBO.cadastrarPreDiagnostico(preDiagnostico);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(preDiagnostico.getIdPreDiagnostico());
        return Response.created(builder.build()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPreDiagnosticos() throws SQLException {
        List<PreDiagnosticoVO> preDiagnosticos = preDiagnosticoBO.listarPreDiagnosticos();
        return Response.ok(preDiagnosticos).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarPreDiagnostico(PreDiagnosticoVO preDiagnostico, @PathParam("id") String id) throws SQLException {
        if (preDiagnostico.getIdPreDiagnostico() == null || preDiagnostico.getDiagnostico() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("ID e Diagnóstico são obrigatórios.").build();
        }

        preDiagnosticoBO.atualizarPreDiagnostico(preDiagnostico);
        return Response.ok().build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deletarPreDiagnostico(@PathParam("id") String id) throws SQLException {
        preDiagnosticoBO.deletarPreDiagnostico(id);
        return Response.ok().build();
    }

}


