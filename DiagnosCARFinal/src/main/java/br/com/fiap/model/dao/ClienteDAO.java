package br.com.fiap.model.dao;

import br.com.fiap.model.vo.Cliente;
import br.com.fiap.connection.ConnDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private Connection conexao;

    public ClienteDAO() throws ClassNotFoundException, SQLException {
        this.conexao = new ConnDAO().conexao();
    }

    // Inserir
    public String ClienteDAO_Inserir(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO CLIENTE (CPF_CLIENTE, CNH_CLIENTE, RG_CLIENTE, NOME_CLIENTE, SOBRENOME_CLIENTE, DATA_NASC_CLIENTE, EMAIL_CLIENTE, SENHA_CLIENTE, TELEFONE_CLIENTE, ENDERECO_CLIENTE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getCpfCliente());
            stmt.setString(2, cliente.getCnhCliente());
            stmt.setString(3, cliente.getRgCliente());
            stmt.setString(4, cliente.getNomeCliente());
            stmt.setString(5, cliente.getSobrenomeCliente());
            stmt.setDate(6, new java.sql.Date(cliente.getDataNascCliente().getTime()));
            stmt.setString(7, cliente.getEmailCliente());
            stmt.setString(8, cliente.getSenhaCliente());
            stmt.setString(9, cliente.getTelefoneCliente());
            stmt.setString(10, cliente.getEnderecoCliente());
            stmt.executeUpdate();
        }
        return "Cliente cadastrado com sucesso!";
    }

    // Deletar
    public String ClienteDAO_Deletar(String cpfCliente) throws SQLException {
        String sql = "DELETE FROM CLIENTE WHERE CPF_CLIENTE = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpfCliente);
            stmt.executeUpdate();
        }
        return "Cliente deletado com sucesso!";
    }

    // Atualizar
    public String ClienteDAO_Atualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE CLIENTE SET CNH_CLIENTE = ?, RG_CLIENTE = ?, NOME_CLIENTE = ?, SOBRENOME_CLIENTE = ?, DATA_NASC_CLIENTE = ?, EMAIL_CLIENTE = ?, SENHA_CLIENTE = ?, TELEFONE_CLIENTE = ?, ENDERECO_CLIENTE = ? WHERE CPF_CLIENTE = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getCnhCliente());
            stmt.setString(2, cliente.getRgCliente());
            stmt.setString(3, cliente.getNomeCliente());
            stmt.setString(4, cliente.getSobrenomeCliente());
            stmt.setDate(5, new java.sql.Date(cliente.getDataNascCliente().getTime()));
            stmt.setString(6, cliente.getEmailCliente());
            stmt.setString(7, cliente.getSenhaCliente());
            stmt.setString(8, cliente.getTelefoneCliente());
            stmt.setString(9, cliente.getEnderecoCliente());
            stmt.setString(10, cliente.getCpfCliente());
            stmt.executeUpdate();
        }
        return "Cliente atualizado com sucesso!";
    }

    // Selecionar
    public List<Cliente> ClienteDAO_Selecionar() throws SQLException {
        List<Cliente> listaCliente = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTE";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getString("CPF_CLIENTE"),
                    rs.getString("CNH_CLIENTE"),
                    rs.getString("RG_CLIENTE"),
                    rs.getString("NOME_CLIENTE"),
                    rs.getString("SOBRENOME_CLIENTE"),
                    rs.getDate("DATA_NASC_CLIENTE"),
                    rs.getString("EMAIL_CLIENTE"),
                    rs.getString("SENHA_CLIENTE"),
                    rs.getString("TELEFONE_CLIENTE"),
                    rs.getString("ENDERECO_CLIENTE")
                );
                listaCliente.add(cliente);
            }
        }
        return listaCliente;
    }
}
