package sprint4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sprint4.conection.ConnDAO;
import sprint4.model.vo.Cliente;

public class ClienteDAO {

    public boolean inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (CPF_Cliente, CNH_Cliente, RG_Cliente, Nome_Cliente, Sobrenome_Cliente, Email_Cliente, Senha_Cliente, Telefone_Cliente, Endereco_Cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConnDAO.conectar();
            conn.setAutoCommit(false);

            ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getCpfCliente());
            ps.setString(2, cliente.getCnhCliente());
            ps.setString(3, cliente.getRgCliente());
            ps.setString(4, cliente.getNomeCliente());
            ps.setString(5, cliente.getSobrenomeCliente());
            ps.setString(6, cliente.getEmailCliente());
            ps.setString(7, cliente.getSenhaCliente());
            ps.setString(8, cliente.getTelefoneCliente());
            ps.setString(9, cliente.getEnderecoCliente());

            int rowsInserted = ps.executeUpdate();
            conn.commit();

            if (rowsInserted > 0) {
                System.out.println("Cliente cadastrado com sucesso!");
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
                if (ps != null) ps.close();
                if (conn != null) ConnDAO.desconectar(conn);
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
    }

    public Cliente buscarPorEmail(String email) {
        String sql = "SELECT * FROM Cliente WHERE Email_Cliente = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try {
            conn = ConnDAO.conectar();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Preencher o objeto Cliente com os dados do ResultSet
                cliente = new Cliente(
                    rs.getString("CPF_Cliente"),
                    rs.getString("CNH_Cliente"),
                    rs.getString("RG_Cliente"),
                    rs.getString("Nome_Cliente"),
                    rs.getString("Sobrenome_Cliente"),
                    rs.getString("Email_Cliente"),
                    rs.getString("Senha_Cliente"),
                    rs.getString("Telefone_Cliente"),
                    rs.getString("Endereco_Cliente")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar cliente por e-mail: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) ConnDAO.desconectar(conn);
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
        return cliente;
    }

    public Cliente buscarClientePorId(int id) {
        String sql = "SELECT * FROM Cliente WHERE ID_Cliente = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try {
            conn = ConnDAO.conectar();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Preencher o objeto Cliente com os dados do ResultSet
                cliente = new Cliente(
                    rs.getString("CPF_Cliente"),
                    rs.getString("CNH_Cliente"),
                    rs.getString("RG_Cliente"),
                    rs.getString("Nome_Cliente"),
                    rs.getString("Sobrenome_Cliente"),
                    rs.getString("Email_Cliente"),
                    rs.getString("Senha_Cliente"),
                    rs.getString("Telefone_Cliente"),
                    rs.getString("Endereco_Cliente")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar cliente por ID: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) ConnDAO.desconectar(conn);
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
        return cliente;
    }

    public boolean deletarCliente(int id) {
        String sql = "DELETE FROM Cliente WHERE ID_Cliente = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConnDAO.conectar();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Cliente deletado com sucesso!");
                return true;
            } else {
                System.out.println("Nenhum cliente encontrado com o ID: " + id);
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao deletar cliente: " + e.getMessage());
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
