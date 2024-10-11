package sprint4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sprint4.conection.ConnDAO;
import sprint4.model.vo.Cliente;



public class ClienteDAO {
    public boolean inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (CPF_Cliente, CNH_Cliente, Nome_Cliente, Sobrenome_Cliente, Email_Cliente, Telefone_Cliente, Endereco_Cliente) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnDAO.conectar();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getCpfCliente());
            stmt.setLong(2, cliente.getCnhCliente());
            stmt.setString(3, cliente.getNomeCliente());
            stmt.setString(4, cliente.getSobrenomeCliente());
            stmt.setString(5, cliente.getEmailCliente());
            stmt.setString(6, cliente.getTelefoneCliente());
            stmt.setString(7, cliente.getEnderecoCliente());

            int rowsInserted = stmt.executeUpdate();
            conn.commit();

            if (rowsInserted > 0) {
                System.out.println("Cliente inserido com sucesso!");
                return true;
            } else {
                System.out.println("Nenhum cliente foi inserido.");
                return false;
            }

        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
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


