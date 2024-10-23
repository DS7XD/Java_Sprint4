package controller;

import java.util.Scanner;

import model.dao.ClienteDAO;
import model.vo.Cliente;

public class ClienteController {

    private ClienteDAO clienteDAO;

    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }

    public void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Informe o PRIMEIRO NOME do cliente:");
        String nome = scanner.nextLine();

        System.out.println("Informe o SOBRENOME do cliente:");
        String sobrenome = scanner.nextLine();
        
        System.out.println("Informe o CPF do cliente (Exemplo: 123.456.789-00):");
        String cpf = scanner.nextLine();
        
        System.out.println("Informe o RG do cliente (Exemplo: 12.345.678-9)");
        String rg = scanner.nextLine();
        
        System.out.println("Informe a CNH do cliente (Exemplo: 00011122233):");
        String cnh = scanner.nextLine();

        System.out.println("Informe o EMAIL do cliente:");
        String email = scanner.nextLine();
        
        System.out.println("Informe o SENHA do cliente:");
        String senha = scanner.nextLine();

        System.out.println("Informe o TELEFONE do cliente (Exemplo: (00) 12345-6789):");
        String telefone = scanner.nextLine();

        System.out.println("Informe o endereço do cliente (Rua, Número, Bairro, Cidade, Sigla do Estado):");
        String endereco = scanner.nextLine();

        Cliente cliente = new Cliente(cpf, cnh, rg, nome, sobrenome, email, senha, telefone, endereco);
        
        boolean sucesso = clienteDAO.inserirCliente(cliente);
        if (sucesso) {
            System.out.println(" ");
        } else {
            System.out.println("Falha ao cadastrar cliente.");
        }
        
    }
}
