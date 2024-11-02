package br.com.fiap.model.dao;

import br.com.fiap.connection.ConnDAO;
import br.com.fiap.model.vo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO Cliente (CPF_Cliente, CNH_Cliente, RG_Cliente, Nome_Cliente, Sobrenome_Cliente, DataNasc_Cliente, Email_Cliente, Senha_Cliente, Telefone_Cliente, Endereco_Cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, cliente.getCpfCliente());
            pstmt.setString(2, cliente.getCnhCliente());
            pstmt.setString(3, cliente.getRgCliente());
            pstmt.setString(4, cliente.getNomeCliente());
            pstmt.setString(5, cliente.getSobrenomeCliente());
            pstmt.setDate(6, new java.sql.Date(cliente.getDataNascCliente().getTime()));
            pstmt.setString(7, cliente.getEmailCliente());
            pstmt.setString(8, cliente.getSenhaCliente());
            pstmt.setString(9, cliente.getTelefoneCliente());
            pstmt.setString(10, cliente.getEnderecoCliente());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente buscarPorCpf(String cpf) {
        String sql = "SELECT * FROM Cliente WHERE CPF_Cliente = ?";
        Cliente cliente = null;

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, cpf);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente(
                    rs.getString("CPF_Cliente"),
                    rs.getString("CNH_Cliente"),
                    rs.getString("RG_Cliente"),
                    rs.getString("Nome_Cliente"),
                    rs.getString("Sobrenome_Cliente"),
                    rs.getDate("DataNasc_Cliente"),
                    rs.getString("Email_Cliente"),
                    rs.getString("Senha_Cliente"),
                    rs.getString("Telefone_Cliente"),
                    rs.getString("Endereco_Cliente")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }

    public void atualizar(Cliente cliente) {
        String sql = "UPDATE Cliente SET CNH_Cliente = ?, RG_Cliente = ?, Nome_Cliente = ?, Sobrenome_Cliente = ?, DataNasc_Cliente = ?, Email_Cliente = ?, Senha_Cliente = ?, Telefone_Cliente = ?, Endereco_Cliente = ? WHERE CPF_Cliente = ?";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, cliente.getCnhCliente());
            pstmt.setString(2, cliente.getRgCliente());
            pstmt.setString(3, cliente.getNomeCliente());
            pstmt.setString(4, cliente.getSobrenomeCliente());
            pstmt.setDate(5, new java.sql.Date(cliente.getDataNascCliente().getTime()));
            pstmt.setString(6, cliente.getEmailCliente());
            pstmt.setString(7, cliente.getSenhaCliente());
            pstmt.setString(8, cliente.getTelefoneCliente());
            pstmt.setString(9, cliente.getEnderecoCliente());
            pstmt.setString(10, cliente.getCpfCliente());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(String cpf) {
        String sql = "DELETE FROM Cliente WHERE CPF_Cliente = ?";

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, cpf);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listarTodos() {
        String sql = "SELECT * FROM Cliente";
        List<Cliente> clientes = new ArrayList<>();

        try (Connection conn = ConnDAO.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
             
            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getString("CPF_Cliente"),
                    rs.getString("CNH_Cliente"),
                    rs.getString("RG_Cliente"),
                    rs.getString("Nome_Cliente"),
                    rs.getString("Sobrenome_Cliente"),
                    rs.getDate("DataNasc_Cliente"),
                    rs.getString("Email_Cliente"),
                    rs.getString("Senha_Cliente"),
                    rs.getString("Telefone_Cliente"),
                    rs.getString("Endereco_Cliente")
                );
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }
}
