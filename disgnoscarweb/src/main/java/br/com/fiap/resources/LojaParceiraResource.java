// LojaParceiraResource.java
package br.com.fiap.resources;

import br.com.fiap.model.bo.LojaParceiraBO;
import br.com.fiap.model.vo.Loja_Parceira;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.SQLException;
import java.util.List;

@Path("/loja-parceira")
public class LojaParceiraResource {
    
    private LojaParceiraBO lojaParceiraBO = new LojaParceiraBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(Loja_Parceira lojaParceira, @Context UriInfo uriInfo) {
        try {
            String resultado = lojaParceiraBO.cadastrarLojaParceira(lojaParceira);
            UriBuilder builder = uriInfo.getAbsolutePathBuilder();
            builder.path(lojaParceira.getEnderecoLoja());
            return Response.created(builder.build())
                          .entity(resultado)
                          .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                          .entity(e.getMessage())
                          .build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity("Erro ao cadastrar loja parceira: " + e.getMessage())
                          .build();
        }
    }

    @PUT
    @Path("/{endereco}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(Loja_Parceira lojaParceira, @PathParam("endereco") String endereco) {
        try {
            lojaParceira.setEnderecoLoja(endereco);
            String resultado = lojaParceiraBO.atualizarLojaParceira(lojaParceira);
            return Response.ok()
                          .entity(resultado)
                          .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                          .entity(e.getMessage())
                          .build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity("Erro ao atualizar loja parceira: " + e.getMessage())
                          .build();
        }
    }

    @DELETE
    @Path("/{endereco}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletar(@PathParam("endereco") String endereco) {
        try {
            String resultado = lojaParceiraBO.deletarLojaParceira(endereco);
            return Response.ok()
                          .entity(resultado)
                          .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                          .entity(e.getMessage())
                          .build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity("Erro ao deletar loja parceira: " + e.getMessage())
                          .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        try {
            List<Loja_Parceira> lojas = lojaParceiraBO.listarLojasParceiras();
            return Response.ok(lojas).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity("Erro ao listar lojas parceiras: " + e.getMessage())
                          .build();
        }
    }

    // Endpoints adicionais

    @GET
    @Path("/especializacao/{especializacao}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorEspecializacao(@PathParam("especializacao") String especializacao) {
        try {
            List<Loja_Parceira> lojas = lojaParceiraBO.buscarPorEspecializacao(especializacao);
            return Response.ok(lojas).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity("Erro ao buscar lojas por especialização: " + e.getMessage())
                          .build();
        }
    }

    @GET
    @Path("/avaliacao/{avaliacaoMinima}")
    @Produces(MediaType.APPLICATION_JSON )
    public Response buscarPorAvaliacao(@PathParam("avaliacaoMinima") double avaliacaoMinima) {
        try {
            List<Loja_Parceira> lojas = lojaParceiraBO.buscarPorAvaliacao(avaliacaoMinima);
            return Response.ok(lojas).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity("Erro ao buscar lojas por avaliação: " + e.getMessage())
                          .build();
        }
    }
}