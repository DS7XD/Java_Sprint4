package controller;

import java.util.Scanner;

import model.dao.ClienteDAO;
import model.vo.Cliente;

public class LoginController {

    private ClienteDAO clienteDAO;

    public LoginController() {
        this.clienteDAO = new ClienteDAO();
    }

    public void realizarLogin() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Informe o EMAIL do cliente:");
        String email = scanner.nextLine();
        
        System.out.println("Informe a SENHA do cliente:");
        String senha = scanner.nextLine();
        
        Cliente cliente = clienteDAO.buscarPorEmail(email);
        
        if (cliente != null && cliente.getSenhaCliente().equals(senha)) {
            System.out.println("Login realizado com sucesso!");
        } else {
            System.out.println("E-mail ou senha inválidos. Tente novamente.");
        }
    }
}
