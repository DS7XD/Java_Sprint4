package main;

import java.util.Scanner;

import controller.ClienteController;
import controller.AutomovelController;
import controller.LoginController;

public class TesteMain {

    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();
        AutomovelController automovelController = new AutomovelController();
        LoginController loginController = new LoginController();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastro");
            System.out.println("2. Login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção (1-3): ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\nCadastro Iniciado:");
                    clienteController.cadastrarCliente();
                    automovelController.inserirAutomovel();
                    break;
                case 2:
                    System.out.println("\nLogin Iniciado:");
                    loginController.realizarLogin();
                    break;
                case 3:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }
}
