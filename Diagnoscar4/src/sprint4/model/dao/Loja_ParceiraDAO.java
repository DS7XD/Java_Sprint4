package sprint4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sprint4.conection.ConnDAO;
import sprint4.model.vo.Loja_Parceira;



public class Loja_ParceiraDAO {

    public boolean inserirLojaParceira(Loja_Parceira lojaParceira) {
        String sql = "INSERT INTO Loja_Parceira (Endereco_Loja, Cnpj_Loja, Nome_Loja, Avaliacao_Loja, Especializacao_Loja) VALUES (?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnDAO.conectar();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, lojaParceira.getEndereco_loja());
            stmt.setString(2, lojaParceira.getCnpj());
            stmt.setString(3, lojaParceira.getNome_loja());
            stmt.setDouble(4, lojaParceira.getAvaliacao());
            stmt.setString(5, lojaParceira.getEspecializacao());

            int rowsInserted = stmt.executeUpdate();
            conn.commit();

            if (rowsInserted > 0) {
                System.out.println("Loja parceira inserida com sucesso!");
                return true;
            } else {
                System.out.println("Nenhuma loja parceira foi inserida.");
                return false;
            }

        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
            System.out.println("Erro ao inserir loja parceira: " + e.getMessage());
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
