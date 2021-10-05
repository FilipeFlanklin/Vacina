package br.ucb.classe.menu;

import java.util.Scanner;

public class MenuPrimario implements Menu {
	private static final Scanner scan = new Scanner(System.in);

	@Override
	public int executar() {

		System.out.println("1 - Paciente");
		System.out.println("2 - Vacina");
		System.out.println("0 - sair");
		System.out.print("Digite uma opção: ");
		Integer opcao = scan.nextInt();
		return opcao;
	}
}
