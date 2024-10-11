package sprint4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sprint4.conection.ConnDAO;
import sprint4.model.vo.Pre_Diagnostico;



public class Pre_DiagnosticoDAO {

    public boolean inserirPreDiagnostico(Pre_Diagnostico preDiagnostico) {
        String sql = "INSERT INTO Pre_Diagnostico (ID_PreDiagnostico, Nivel_Diagnostico, Diagnostico, Assistente_ID_Chatbot) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnDAO.conectar();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, preDiagnostico.getIdPreDiagnostico());
            stmt.setInt(2, preDiagnostico.getNivelDiagnostico());
            stmt.setString(3, preDiagnostico.getDiagnostico());
            stmt.setString(4, preDiagnostico.getAssistenteIdChatbot());

            int rowsInserted = stmt.executeUpdate();
            conn.commit();

            if (rowsInserted > 0) {
                System.out.println("Pré-Diagnóstico inserido com sucesso!");
                return true;
            } else {
                System.out.println("Nenhum pré-diagnóstico foi inserido.");
                return false;
            }

        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
            System.out.println("Erro ao inserir pré-diagnóstico: " + e.getMessage());
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) ConnDAO.desconectar(conn);
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
    }
}
