package br.com.fiap.model.dao;

import br.com.fiap.model.vo.TabelaAssociativa;
import br.com.fiap.connection.ConnDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssociacaoDAO {

    private Connection conexao;

    public AssociacaoDAO() throws ClassNotFoundException, SQLException {
        super();
        this.conexao = new ConnDAO().conexao();
    }

    public boolean associacaoExiste(String cpfCliente, String idChatbot) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Tabela_de_Associacao WHERE CPF_Cliente = ? AND ID_Chatbot = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpfCliente);
            stmt.setString(2, idChatbot);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public String inserir(TabelaAssociativa associacao) throws SQLException {
        String sql = "INSERT INTO Tabela_de_Associacao (CPF_Cliente, ID_Chatbot, Endereco_Loja) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, associacao.getCpfCliente());
            stmt.setString(2, associacao.getIdChatbot());
            stmt.setString(3, associacao.getEnderecoLoja());
            stmt.execute();
        }
        return "Associação cadastrada com sucesso!";
    }

    public String deletar(String cpfCliente, String idChatbot) throws SQLException {
        String sql = "DELETE FROM Tabela_de_Associacao WHERE CPF_Cliente = ? AND ID_Chatbot = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpfCliente);
            stmt.setString(2, idChatbot);
            stmt.execute();
        }
        return "Associação deletada com sucesso!";
    }

    public String atualizar(TabelaAssociativa associacao) throws SQLException {
        String sql = "UPDATE Tabela_de_Associacao SET Endereco_Loja = ? WHERE CPF_Cliente = ? AND ID_Chatbot = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, associacao.getEnderecoLoja());
            stmt.setString(2, associacao.getCpfCliente());
            stmt.setString(3, associacao.getIdChatbot());
            stmt.executeUpdate();
        }
        return "Associação atualizada com sucesso!";
    }

    public List<TabelaAssociativa> selecionar() throws SQLException {
        List<TabelaAssociativa> listaAssociacao = new ArrayList<>();
        String sql = "SELECT * FROM Tabela_de_Associacao";
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                TabelaAssociativa associacao = new TabelaAssociativa(
                    rs.getString("CPF_Cliente"),
                    rs.getString("ID_Chatbot"),
                    rs.getString("Endereco_Loja")
                );
                listaAssociacao.add(associacao);
            }
        }
        return listaAssociacao;
    }
}
