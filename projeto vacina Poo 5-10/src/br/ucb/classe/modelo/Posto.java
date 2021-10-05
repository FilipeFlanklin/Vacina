package br.ucb.classe.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Posto {

	private static List<Vacina> listaVacinas = new ArrayList<>();

	private static List<Paciente> listaPacientes = new ArrayList<>();

	private static Collection<Enfermeiro> listaEnfermeiros = new ArrayList<>();

	static {
		
		Enfermeiro enf1 = new Enfermeiro("Carlos", 27, "04649781354", 3211, "Taguatinga");
		Enfermeiro enf2 = new Enfermeiro("Marcela", 42, "01154987566", 0142, "Guará");
		Enfermeiro enf3 = new Enfermeiro("Luciana", 33, "05589654235", 7423, "Ceilândia");
		listaEnfermeiros.add(enf1);
		listaEnfermeiros.add(enf2);
		listaEnfermeiros.add(enf3);

		Vacina vac1 = new Vacina("Pfizer", 20, 1, LocalDateTime.now().plusDays(100), 2);
		Vacina vac2 = new Vacina("Janssen", 10, 2, LocalDateTime.now().plusDays(100), 1);
		Vacina vac3 = new Vacina("Coronavac", 50, 3, LocalDateTime.now().plusDays(100), 2);
		listaVacinas.add(vac1);
		listaVacinas.add(vac2);
		listaVacinas.add(vac3);
	}

	public static List<Vacina> getListaVacinas() {
		return Collections.unmodifiableList(listaVacinas);

	}

	public static List<Paciente> getListaPacientes() {
		return Collections.unmodifiableList(listaPacientes);
	}

	public static List<?> getListaEnfermeiro() {
		Collections.shuffle((List<?>) listaEnfermeiros);
		return Collections.unmodifiableList((List<?>) listaEnfermeiros);
	}

	public static void adicionarVacinas(Vacina v) {
		listaVacinas.add(v);
	}

	public static void adicionarPacientes(Paciente p) {
		listaPacientes.add(p);
	}

	public static boolean removerVacina(String nome) {
			if (listaVacinas.removeIf(v -> (v.getNome().equals(nome)))) {
				return true;
			}
		return false;
	}

	public static Paciente getListaPacienteEspecifico(String cpf) {
		for (Paciente p : listaPacientes) {
			if (p.getCpf().equals(cpf)) {
				return p;
			}
		}
		return null;
	}

	public static void utilizarVacina(int lote, Paciente pacienteExpecifico) {
		Vacina vacinaUtilizada = null;
		for (Vacina v : listaVacinas) {
			if(v.getLote() == lote) {
				vacinaUtilizada = v;
				v.setQuantDoses(v.getQuantDoses() - 1);
			}
		}
		pacienteExpecifico.setVacinaRecebida(vacinaUtilizada);
		pacienteExpecifico.setQuantidadeDoses(pacienteExpecifico.getQuantidadeDoses() + 1);
	}
	
	public static void utilizarVacina(Vacina vacinaUtilizada, Paciente pacienteExpecifico) {
		vacinaUtilizada.setQuantDoses(vacinaUtilizada.getQuantDoses() - 1);
		pacienteExpecifico.setQuantidadeDoses(pacienteExpecifico.getQuantidadeDoses() + 1);
	}

	public static void ValidarVacinas() {
		listaVacinas.removeIf((vacina) -> vacina.getDataVencimentoInterno().isBefore(LocalDateTime.now()));
		listaVacinas.removeIf((vacina) -> (vacina.getQuantDoses() <= 0));
	}

	public static Vacina getListaVacinaEspecifica(int loteEspecifico) {
		for (Vacina v : listaVacinas) {
			if (v.getLote() == loteEspecifico) {
				return v;
			}
		}
		return null;
	}
}
