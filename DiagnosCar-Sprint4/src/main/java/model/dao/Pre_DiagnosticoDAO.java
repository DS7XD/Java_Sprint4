package model.dao;

import connection.ConnDAO;
import model.vo.Pre_Diagnostico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pre_DiagnosticoDAO {

    public void inserir(Pre_Diagnostico preDiagnostico) {
        String sql = "INSERT INTO Pre_Diagnostico (ID_PreDiagnostico, Nivel_Diagnostico, Diagnostico, " +
                     "Assistente_ID_Chatbot, Cliente_CPF_Cliente, Placa_Automovel) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, preDiagnostico.getIdPreDiagnostico());
            pstmt.setInt(2, preDiagnostico.getNivelDiagnostico());
            pstmt.setString(3, preDiagnostico.getDiagnostico());
            pstmt.setString(4, preDiagnostico.getAssistenteIdChatbot());
            pstmt.setString(5, preDiagnostico.getClienteCpfCliente());
            pstmt.setString(6, preDiagnostico.getPlacaAutomovel());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Pre_Diagnostico buscarPorId(String idPreDiagnostico) {
        String sql = "SELECT * FROM Pre_Diagnostico WHERE ID_PreDiagnostico = ?";
        Pre_Diagnostico preDiagnostico = null;

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, idPreDiagnostico);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                preDiagnostico = new Pre_Diagnostico(
                    rs.getString("ID_PreDiagnostico"),
                    rs.getInt("Nivel_Diagnostico"),
                    rs.getString("Diagnostico"),
                    rs.getString("Assistente_ID_Chatbot"),
                    rs.getString("Cliente_CPF_Cliente"),
                    rs.getString("Placa_Automovel")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preDiagnostico;
    }

    public void atualizar(Pre_Diagnostico preDiagnostico) {
        String sql = "UPDATE Pre_Diagnostico SET Nivel_Diagnostico = ?, Diagnostico = ?, " +
                     "Assistente_ID_Chatbot = ?, Cliente_CPF_Cliente = ?, Placa_Automovel = ? WHERE ID_PreDiagnostico = ?";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, preDiagnostico.getNivelDiagnostico());
            pstmt.setString(2, preDiagnostico.getDiagnostico());
            pstmt.setString(3, preDiagnostico.getAssistenteIdChatbot());
            pstmt.setString(4, preDiagnostico.getClienteCpfCliente());
            pstmt.setString(5, preDiagnostico.getPlacaAutomovel());
            pstmt.setString(6, preDiagnostico.getIdPreDiagnostico());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(String idPreDiagnostico) {
        String sql = "DELETE FROM Pre_Diagnostico WHERE ID_PreDiagnostico = ?";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, idPreDiagnostico);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pre_Diagnostico> listarTodos() {
        String sql = "SELECT * FROM Pre_Diagnostico";
        List<Pre_Diagnostico> preDiagnosticos = new ArrayList<>();

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
             
            while (rs.next()) {
                Pre_Diagnostico preDiagnostico = new Pre_Diagnostico(
                    rs.getString("ID_PreDiagnostico"),
                    rs.getInt("Nivel_Diagnostico"),
                    rs.getString("Diagnostico"),
                    rs.getString("Assistente_ID_Chatbot"),
                    rs.getString("Cliente_CPF_Cliente"),
                    rs.getString("Placa_Automovel")
                );
                preDiagnosticos.add(preDiagnostico);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preDiagnosticos;
    }
}
