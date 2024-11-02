package br.com.fiap.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.model.vo.Cliente;
import br.com.fiap.model.dao.ClienteDAO;

public class ClienteBO {

    ClienteDAO clienteDAO = null;

    public void cadastrarCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.ClienteDAO_Inserir(cliente);
    }

    public void atualizarCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.ClienteDAO_Atualizar(cliente);
    }

    public void deletarCliente(String cpfCliente) throws ClassNotFoundException, SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.ClienteDAO_Deletar(cpfCliente);
    }

    public ArrayList<Cliente> listarClientes() throws ClassNotFoundException, SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();
        return (ArrayList<Cliente>) clienteDAO.ClienteDAO_Selecionar();
    }
}
