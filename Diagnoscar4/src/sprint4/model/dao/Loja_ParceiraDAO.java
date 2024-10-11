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
        PreparedStatement ps = null;

        try {
            conn = ConnDAO.conectar();
            conn.setAutoCommit(false);

            ps = conn.prepareStatement(sql);
            ps.setString(1, lojaParceira.getEndereco_loja());
            ps.setString(2, lojaParceira.getCnpj());
            ps.setString(3, lojaParceira.getNome_loja());
            ps.setDouble(4, lojaParceira.getAvaliacao());
            ps.setString(5, lojaParceira.getEspecializacao());

            int rowsInserted = ps.executeUpdate();
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
                if (ps != null) ps.close();
                if (conn != null) ConnDAO.desconectar(conn);
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
    }
}
