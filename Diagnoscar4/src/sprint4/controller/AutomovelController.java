package sprint4.controller;

import java.util.Scanner;

import sprint4.model.dao.AutomovelDAO;
import sprint4.model.vo.Automovel;

public class AutomovelController {
    private AutomovelDAO automovelDAO;

    public AutomovelController() {
        this.automovelDAO = new AutomovelDAO();
    }

    public void inserirAutomovel() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a placa do automóvel: ");
        String placa = scanner.nextLine();

        System.out.print("Digite a marca do automóvel: ");
        String marca = scanner.nextLine();

        System.out.print("Digite o modelo do automóvel: ");
        String modelo = scanner.nextLine();

        System.out.print("Digite a cor do automóvel: ");
        String cor = scanner.nextLine();

        System.out.print("Digite o ano do automóvel: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        Automovel automovel = new Automovel(placa, marca, modelo, cor, ano, cpf);

        if (automovelDAO.inserirAutomovel(automovel)) {
            System.out.println("Automóvel adicionado com sucesso!");
        } else {
            System.out.println("Falha ao adicionar automóvel.");
        }
    }
}
