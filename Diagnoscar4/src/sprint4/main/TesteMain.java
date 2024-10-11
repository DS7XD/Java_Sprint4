package sprint4.main;

import java.util.Scanner;

import sprint4.controller.*;
import sprint4.model.*;

public class TesteMain {

    public static void main(String[] args) {
	ClienteController ClienteController = new ClienteController();
	AutomovelController AutomovelController = new AutomovelController();
	
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Fazer o Cadastro de Cliente");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção (1-3): ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    ClienteController.cadastrarCliente();
                    AutomovelController.inserirAutomovel();
                    break;
                case 2:
                    System.out.println("fo");
                    break;
                case 3:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}