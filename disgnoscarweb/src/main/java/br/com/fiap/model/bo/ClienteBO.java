package br.com.fiap.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.model.vo.Cliente;
import br.com.fiap.model.dao.ClienteDAO;

public class ClienteBO {
    ClienteDAO clienteDAO;

    public ClienteBO() throws ClassNotFoundException, SQLException {
        this.clienteDAO = new ClienteDAO();
    }

    public void cadastrarCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
        clienteDAO.ClienteDAO_Inserir(cliente);
    }

    public void atualizarCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
        clienteDAO.ClienteDAO_Atualizar(cliente);
    }

    public void deletarCliente(String cpfCliente) throws ClassNotFoundException, SQLException {
        clienteDAO.ClienteDAO_Deletar(cpfCliente);
    }

    public ArrayList<Cliente> listarClientes() throws ClassNotFoundException, SQLException {
        return (ArrayList<Cliente>) clienteDAO.ClienteDAO_Selecionar();
    }
    
    public boolean clienteExists(String cpfCliente) throws SQLException {
        return clienteDAO.clienteExiste(cpfCliente);
    }
}
