package br.ucb.classe.teste;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import br.ucb.classe.menu.MenuPaciente;
import br.ucb.classe.menu.MenuPrimario;
import br.ucb.classe.menu.MenuVacina;
import br.ucb.classe.modelo.Paciente;
import br.ucb.classe.modelo.Posto;
import br.ucb.classe.modelo.Vacina;

public class Atendimento {
	public static void main(String[] args) {

		int opcao;
		int opcaoEspecifica;
		Scanner scan = new Scanner(System.in);

		do {
			opcao = new MenuPrimario().executar();
			switch (opcao) {
			case 1:
				System.out.println("\n*Paciente*\n");
				do {
					opcaoEspecifica = new MenuPaciente().executar();
					switch (opcaoEspecifica) {
					case 1:
						System.out.println("\n*Cadastrar Paciente*\n");
						System.out.print("Digite o nome: ");
						String nome = scan.nextLine();

						System.out.print("Digite a idade: ");
						int idade = Integer.parseInt(scan.nextLine());

						System.out.print("Digite o cpf: ");
						String cpf = scan.nextLine();

						System.out.print("Digite o Endereço: ");
						String endereco = scan.nextLine();
						System.out.println();

						Paciente paciente = new Paciente(nome, idade, cpf, endereco);
						Posto.adicionarPacientes(paciente);
						break;
					case 2:
						System.out.println("\n*Verificar dados do paciente*\n");
						System.out.print("Informe seu cpf: ");
						String cpfPesquisa = scan.nextLine();
						System.out.println();

						Paciente pacienteEspecifico = Posto.getListaPacienteEspecifico(cpfPesquisa);
						if (pacienteEspecifico != null) {
							System.out.println(pacienteEspecifico);
							System.out.println();
						} else {
							System.out.println("Paciente não encontrado\r\n");
						}
						break;
					case 3:
						System.out.println("\n*Atualizar dados do paciente*\n");
						System.out.print("Informe seu cpf: ");
						String cpfPesquisa2 = scan.nextLine();
						System.out.println();

						Paciente pacienteExpecificoAlterado = Posto.getListaPacienteEspecifico(cpfPesquisa2);
						if (pacienteExpecificoAlterado != null) {
							System.out.print("Dados atuais: \r\n");
							System.out.println(pacienteExpecificoAlterado);
							System.out.println();

							System.out.print("Digite o novo nome: ");
							String nomeAlterado = scan.nextLine();
							pacienteExpecificoAlterado.setNome(nomeAlterado);

							System.out.print("Digite a nova idade: ");
							int idadeAlterado = Integer.parseInt(scan.nextLine());
							pacienteExpecificoAlterado.setIdade(idadeAlterado);

							System.out.print("Digite o novo cpf: ");
							String cpfAlterado = scan.nextLine();
							pacienteExpecificoAlterado.setCpf(cpfAlterado);

							System.out.print("Digite o novo endereço: ");
							String enderecoAlterado = scan.nextLine();
							pacienteExpecificoAlterado.setEndereco(enderecoAlterado);
							System.out.println();
						} else {
							System.out.println("Paciente não encontrado");
						}
						break;
					case 4:
						System.out.println("\n*Aplicar dose da vacina*\n");
						System.out.print("Informe seu cpf: ");
						String cpfPesquisa3 = scan.nextLine();
						System.out.println();

						pacienteEspecifico = Posto.getListaPacienteEspecifico(cpfPesquisa3);
						if (pacienteEspecifico != null) {
							Posto.ValidarVacinas();

							if (pacienteEspecifico.getQuantidadeDoses() == 0) {
								List<Vacina> listaVacinas = Posto.getListaVacinas();
								listaVacinas.forEach(System.out::println);
								System.out.println();
								System.out.print("Digite o Número da Vacina: ");
								int opcaoVacina = Integer.parseInt(scan.nextLine());
								Posto.utilizarVacina(opcaoVacina, pacienteEspecifico);
								pacienteEspecifico.setDatas(pacienteEspecifico);

							} else if (pacienteEspecifico.getQuantidadeDoses() < pacienteEspecifico.getVacinaRecebida()
									.getDosesPorPaciente()
									& pacienteEspecifico.getDataRetornoInterna() == LocalDate.now()) {
								Posto.utilizarVacina(pacienteEspecifico.getVacinaRecebida(), pacienteEspecifico);
								pacienteEspecifico.setDatas(pacienteEspecifico);

							} else if (pacienteEspecifico.getQuantidadeDoses() == pacienteEspecifico.getVacinaRecebida()
									.getDosesPorPaciente()) {
								System.out.println("Paciente já tomou todas as doses\r\n");
							} else {
								System.out.println("Paciente não Encontrado\r\n");
							}
						}
						System.out.println();
						break;
					}
				} while (opcaoEspecifica != 0);
				break;
			case 2:
				System.out.println("\n*Vacina*\n");
				do {
					opcaoEspecifica = new MenuVacina().executar();
					switch (opcaoEspecifica) {
					case 1:
						System.out.println("\n*Cadastrar lote vacina*\n");
						System.out.print("Digite o nome da vacina: ");
						String nome = scan.nextLine();

						System.out.print("Digite a quantidade de doses recebidas: ");
						int quantDoses = Integer.parseInt(scan.nextLine());

						System.out.print("Digite a quantidade de doses por parciente: ");
						int dosePorPaciente = Integer.parseInt(scan.nextLine());

						System.out.print("Digite o número do lote: ");
						int lote = Integer.parseInt(scan.nextLine());

						Vacina vacina = new Vacina(nome, quantDoses, lote, LocalDateTime.now().plusDays(100),
								dosePorPaciente);
						Posto.adicionarVacinas(vacina);
						break;
					case 2:
						System.out.println("\n*Verificar dados do lote de vacinas*\n");
						System.out.print("Informe o lote: ");
						int loteEspecifico = Integer.parseInt(scan.nextLine());
						System.out.println();
						
						Vacina vacinaEspecifico = Posto.getListaVacinaEspecifica(loteEspecifico);
						if (vacinaEspecifico != null) {
							System.out.println(vacinaEspecifico);
							System.out.println();

						} else {
							System.out.println("Vacina não encontrado\r\n");
						}
						break;
					case 3:
						System.out.println("\n*Atualizar dados do lote de vacinas*\n");
						Posto.getListaVacinas().forEach(System.out::println);
						System.out.print("Informe o lote: ");
						int loteEspecifico2 = Integer.parseInt(scan.nextLine());
						System.out.println();

						Vacina vacinaEspecifico2 = Posto.getListaVacinaEspecifica(loteEspecifico2);
						if (vacinaEspecifico2 != null) {
							System.out.print("Digite o novo nome da vacina: ");
							String nomeNovo = scan.nextLine();
							vacinaEspecifico2.setNome(nomeNovo);

							System.out.print("Digite a quantidade de doses recebidas a mais: ");
							int quantDosesNovo = Integer.parseInt(scan.nextLine());
							vacinaEspecifico2.setQuantDoses(vacinaEspecifico2.getQuantDoses() + quantDosesNovo);
						} else {
							System.out.println("Vacina não encontrado\r\n");
						}
						break;
					case 4:
						System.out.println("\n*Remover lote de vacinas*\n");
						Posto.getListaVacinas().forEach(System.out::println);
						System.out.print("Informe o lote: ");
						int loteEspecifico3 = Integer.parseInt(scan.nextLine());
						System.out.println();

						Vacina vacinaEspecifico3 = Posto.getListaVacinaEspecifica(loteEspecifico3);
						if (vacinaEspecifico3 != null) {
							Posto.removerVacina(vacinaEspecifico3.getNome());
						} else {
							System.out.println("Vacina não encontrado\r\n");
						}
						break;
					case 0:
						System.out.println();
						break;
					}
				} while (opcaoEspecifica != 0);
				System.out.println();
			}
		} while (opcao != 0);
		scan.close();
	}
}
