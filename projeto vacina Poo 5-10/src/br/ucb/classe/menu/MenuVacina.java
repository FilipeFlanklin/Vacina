package br.ucb.classe.menu;

import java.util.Scanner;

public class MenuVacina implements Menu{
	private static final Scanner scan = new Scanner(System.in);
	
	@Override
	public int executar() {
		System.out.println("1 - Cadastrar lote vacina");
		System.out.println("2 - Verificar dados do lote de vacinas");
		System.out.println("3 - Atualizar dados do lote de vacinas");
		System.out.println("4 - Remover lote de vacinas");
		System.out.println("0 - Voltar");
		System.out.print("Digite uma opção: ");
		Integer opcao = scan.nextInt();
		return opcao;
		
	}
}
