package br.ucb.classe.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vacina {

	private String nome;
	private int quantDoses;
	private int lote;
	private LocalDateTime dataVencimento;
	private int dosesPorPaciente;

	public Vacina(String nome, int quantDoses, int lote, LocalDateTime dataVencimento, int dosePorPaciente) {
		this.nome = nome;
		this.quantDoses = quantDoses;
		this.lote = lote;
		this.dataVencimento = dataVencimento;
		this.dosesPorPaciente = dosePorPaciente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantDoses() {
		return quantDoses;
	}

	public void setQuantDoses(int quantDoses) {
		this.quantDoses = quantDoses;
	}

	public void setQuantDosesPorPaciente(int dosesPorPaciente) {
		this.dosesPorPaciente = dosesPorPaciente;
	}

	public int getLote() {
		return lote;
	}

	public void setLote(int lote) {
		this.lote = lote;
	}

	public String getDataVencimento() {
		return dataVencimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public LocalDateTime getDataVencimentoInterno() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDateTime dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public int getDosesPorPaciente() {
		return dosesPorPaciente;
	}

	@Override
	public String toString() {
		return lote + "- " + nome + "\r\n" + "Número de doses por parciente- "+ dosesPorPaciente + " | Vencimento - "+ getDataVencimento();
	}

}
