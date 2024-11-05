package br.com.fiap.model.dao;

import br.com.fiap.model.vo.PreDiagnosticoVO;
import br.com.fiap.connection.ConnDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PreDiagnosticoDAO {

    private Connection conexao;

    public PreDiagnosticoDAO() throws ClassNotFoundException, SQLException {
        this.conexao = new ConnDAO().conexao();
    }

    // Método para fechar a conexão
    private void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Inserir
    public String PreDiagnosticoDAO_Inserir(PreDiagnosticoVO preDiagnostico) throws SQLException {
        String sql = "INSERT INTO PRE_DIAGNOSTICO (ID_PRE_DIAGNOSTICO, NIVEL_DIAGNOSTICO, DIAGNOSTICO, ASSISTENTE_ID_CHATBOT, CLIENTE_CPF_CLIENTE, PLACA_AUTOMOVEL) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, preDiagnostico.getIdPreDiagnostico());
            stmt.setInt(2, preDiagnostico.getNivelDiagnostico());
            stmt.setString(3, preDiagnostico.getDiagnostico());
            stmt.setString(4, preDiagnostico.getAssistenteIdChatbot());
            stmt.setString(5, preDiagnostico.getClienteCpfCliente());
            stmt.setString(6, preDiagnostico.getPlacaAutomovel());
            stmt.executeUpdate();
        } finally {
            fecharConexao();
        }
        return "Pré-diagnóstico cadastrado com sucesso!";
    }

    // Deletar
    public String PreDiagnosticoDAO_Deletar(String idPreDiagnostico) throws SQLException {
        String sql = "DELETE FROM PRE_DIAGNOSTICO WHERE ID_PRE_DIAGNOSTICO = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, idPreDiagnostico);
            stmt.executeUpdate();
        } finally {
            fecharConexao();
        }
        return "Pré-diagnóstico deletado com sucesso!";
    }

    // Atualizar
    public String PreDiagnosticoDAO_Atualizar(PreDiagnosticoVO preDiagnostico) throws SQLException {
        String sql = "UPDATE PRE_DIAGNOSTICO SET NIVEL_DIAGNOSTICO = ?, DIAGNOSTICO = ?, ASSISTENTE_ID_CHATBOT = ?, CLIENTE_CPF_CLIENTE = ?, PLACA_AUTOMOVEL = ? WHERE ID_PRE_DIAGNOSTICO = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, preDiagnostico.getNivelDiagnostico());
            stmt.setString(2, preDiagnostico.getDiagnostico());
            stmt.setString(3, preDiagnostico.getAssistenteIdChatbot());
            stmt.setString(4, preDiagnostico.getClienteCpfCliente());
            stmt.setString(5, preDiagnostico.getPlacaAutomovel());
            stmt.setString(6, preDiagnostico.getIdPreDiagnostico());
            stmt.executeUpdate();
        } finally {
            fecharConexao();
        }
        return "Pré-diagnóstico atualizado com sucesso!";
    }

    // Selecionar
    public List<PreDiagnosticoVO> PreDiagnosticoDAO_Selecionar() throws SQLException {
        List<PreDiagnosticoVO> listaPreDiagnosticos = new ArrayList<>();
        String sql = "SELECT * FROM PRE_DIAGNOSTICO";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                PreDiagnosticoVO preDiagnostico = new PreDiagnosticoVO(
                    rs.getString("ID_PRE_DIAGNOSTICO"),
                    rs.getInt("NIVEL_DIAGNOSTICO"),
                    rs.getString("DIAGNOSTICO"),
                    rs.getString("ASSISTENTE_ID_CHATBOT"),
                    rs.getString("CLIENTE_CPF_CLIENTE"),
                    rs.getString("PLACA_AUTOMOVEL")
                );
                listaPreDiagnosticos.add(preDiagnostico);
            }
        } finally {
            fecharConexao();
        }
        return listaPreDiagnosticos;
    }
}
