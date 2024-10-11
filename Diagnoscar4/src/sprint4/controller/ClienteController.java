package sprint4.controller;

import java.util.Scanner;

import sprint4.model.dao.ClienteDAO;
import sprint4.model.vo.Cliente;

public class ClienteController {

    private ClienteDAO clienteDAO;

    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }

    public void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Informe o CPF do cliente ( 123.456.789-00 ):");
        String cpf = scanner.nextLine();
        
        System.out.println("Informe a CNH do cliente ( 00011122233 ):");
        long cnh = scanner.nextLong();
        scanner.nextLine(); // consume the newline

        System.out.println("Informe o PRIMEIRO NOME do cliente:");
        String nome = scanner.nextLine();

        System.out.println("Informe o SOBRENOME do cliente:");
        String sobrenome = scanner.nextLine();

        System.out.println("Informe o EMAIL do cliente:");
        String email = scanner.nextLine();

        System.out.println("Informe o TELEFONE do cliente ( (00) 12345-6789 ):");
        String telefone = scanner.nextLine();

        System.out.println("Informe o endereço do cliente ( Rua, Número, Bairro, Cidade, Sigla do Estado ):");
        String endereco = scanner.nextLine();

        Cliente cliente = new Cliente(cpf, cnh, nome, sobrenome, email, telefone, endereco);
        
        boolean sucesso = clienteDAO.inserirCliente(cliente);
        if (sucesso) {
            System.out.println("Cliente cadastrado com sucesso!");
        } else {
            System.out.println("Falha ao cadastrar cliente.");
        }
        
        scanner.close();
    }

    public static void main(String[] args) {
        ClienteController controller = new ClienteController();
        controller.cadastrarCliente();
    }
}
