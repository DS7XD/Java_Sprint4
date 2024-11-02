package br.com.fiap.resources;

import java.sql.SQLException;
import java.util.ArrayList;

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

import br.com.fiap.model.vo.Cliente;
import br.com.fiap.model.bo.ClienteBO;

@Path("/cliente") // nome da página
public class ClienteResource {
    
    private ClienteBO clienteBO = new ClienteBO();

    // inserir (POST)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastroRs(Cliente cliente, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        clienteBO.cadastrarCliente(cliente);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(cliente.getCpfCliente()); // identificando o CPF do cliente
        return Response.created(builder.build()).build();
    }

    // atualizar (PUT)
    @PUT
    @Path("/{cpfCliente}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizaRs(Cliente cliente, @PathParam("cpfCliente") String cpfCliente) throws ClassNotFoundException, SQLException {
        clienteBO.atualizarCliente(cliente);
        return Response.ok().build();
    }

    // deletar (DELETE)
    @DELETE
    @Path("/{cpfCliente}")
    public Response deletarRs(@PathParam("cpfCliente") String cpfCliente) throws ClassNotFoundException, SQLException {
        clienteBO.deletarCliente(cpfCliente);
        return Response.ok().build();
    }

    // consultar (GET)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Cliente> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Cliente>) clienteBO.listarClientes();
    }
}
