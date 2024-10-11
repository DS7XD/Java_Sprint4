package sprint4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sprint4.conection.ConnDAO;
import sprint4.model.vo.Oficina;




public class OficinaDAO {

    public boolean inserirOficina(Oficina oficina) {
        String sql = "INSERT INTO Oficina (Endereco_Oficina, Cnpj_Oficina, Nome_Oficina, Avaliacao_Oficina, Especializacao_Oficina) VALUES (?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnDAO.conectar();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oficina.getEnderecoOficina());
            stmt.setString(2, oficina.getCnpjOficina());
            stmt.setString(3, oficina.getNomeOficina());
            stmt.setDouble(4, oficina.getAvaliacaoOficina());
            stmt.setString(5, oficina.getEspecializacaoOficina());

            int rowsInserted = stmt.executeUpdate();
            conn.commit();

            if (rowsInserted > 0) {
                System.out.println("Oficina inserida com sucesso!");
                return true;
            } else {
                System.out.println("Nenhuma oficina foi inserida.");
                return false;
            }

        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
            System.out.println("Erro ao inserir oficina: " + e.getMessage());
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



