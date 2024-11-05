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

import br.com.fiap.model.bo.OficinaBO;
import br.com.fiap.model.vo.OficinaVO;

@Path("/oficinas")
public class OficinaResource {
    
    private OficinaBO oficinaBO;
    
    public OficinaResource() throws ClassNotFoundException, SQLException {
        oficinaBO = new OficinaBO();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarOficina(OficinaVO oficina, @Context UriInfo uriInfo) throws SQLException {
        if (oficina.getEnderecoOficina() == null || oficina.getCnpjOficina() == null || oficina.getNomeOficina() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Endereço, CNPJ e Nome são obrigatórios.").build();
        }

        oficinaBO.cadastrarOficina(oficina);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(oficina.getCnpjOficina());
        return Response.created(builder.build()).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarOficinas() throws SQLException {
        List<OficinaVO> oficinas = oficinaBO.listarOficinas();
        return Response.ok(oficinas).build();
    }
    
    @PUT
    @Path("/{cnpjOficina}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarOficina(OficinaVO oficina, @PathParam("cnpjOficina") String cnpjOficina) throws SQLException {
        if (oficina.getEnderecoOficina() == null || oficina.getCnpjOficina() == null || oficina.getNomeOficina() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Endereço, CNPJ e Nome são obrigatórios.").build();
        }
        
        oficinaBO.atualizarOficina(oficina);
        return Response.ok().build();
    }
    
    @DELETE
    @Path("/{cnpjOficina}")
    public Response deletarOficina(@PathParam("cnpjOficina") String cnpjOficina) throws SQLException {
        oficinaBO.deletarOficina(cnpjOficina);
        return Response.ok().build();
    }
    
}

