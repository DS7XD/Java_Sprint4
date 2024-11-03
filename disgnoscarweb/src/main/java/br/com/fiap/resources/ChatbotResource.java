// ChatbotResource.java
package br.com.fiap.resources;

import br.com.fiap.model.bo.ChatbotBO;
import br.com.fiap.model.vo.Chatbot;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.SQLException;
import java.util.List;

@Path("/chatbot")
public class ChatbotResource {
    
    private ChatbotBO chatbotBO = new ChatbotBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(Chatbot chatbot, @Context UriInfo uriInfo) {
        try {
            String resultado = chatbotBO.cadastrarChatbot(chatbot);
            UriBuilder builder = uriInfo.getAbsolutePathBuilder();
            builder.path(chatbot.getIdChatbot());
            return Response.created(builder.build())
                          .entity(resultado)
                          .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                          .entity(e.getMessage())
                          .build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity("Erro ao cadastrar chatbot: " + e.getMessage())
                          .build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(Chatbot chatbot, @PathParam("id") String id ) {
        try {
            chatbot.setIdChatbot(id);
            String resultado = chatbotBO.atualizarChatbot(chatbot);
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
            String resultado = chatbotBO.deletarChatbot(id);
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
            List<Chatbot> chatbots = chatbotBO.listarChatbots();
            return Response.ok(chatbots).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity(e.getMessage())
                          .build();
        }
    }
}