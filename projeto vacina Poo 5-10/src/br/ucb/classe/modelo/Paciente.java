package br.ucb.classe.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Paciente extends Pessoa {

	private int quantidadeDosesRecebidas = 0;
	private LocalDate dataRetorno = null;
	private LocalDate dataPrimeira = null;
	private int codigoEnfermeiro;
	private Vacina vacinaRecebida;

	public Vacina getVacinaRecebida() {
		return vacinaRecebida;
	}

	public Paciente(String nome, int idade, String cpf, String endereco) {
		super(nome, idade, cpf, endereco);
		setCodigoEnfermeiro();
	}

	public int getQuantidadeDoses() {
		return quantidadeDosesRecebidas;
	}
	
	public void setCodigoEnfermeiro() {
		this.codigoEnfermeiro = ((Enfermeiro) Posto.getListaEnfermeiro().get(0)).getCodigo();
	}

	public void setQuantidadeDoses(int quantidadeDosesRecebidas) {
		this.quantidadeDosesRecebidas = quantidadeDosesRecebidas;
	}
	
	
	@Override
	public String toString() {
		if(dataRetorno != null) {
			return "Código do Enfermeiro atendente: " + codigoEnfermeiro + "\r\n" 
					+ "VacinaRecebida: " + vacinaRecebida.getNome() + "\r\n"
						+ "Data da primeira dose: " + getDataPrimeira() + "\r\n" 
							+ "Data de retorno para segunda dose: " + getDataRetorno()+ "\r\n" 
								+ super.toString();
		} else if (vacinaRecebida != null){
			if(vacinaRecebida.getDosesPorPaciente() < 2) {
				return "Código do Enfermeiro atendente: " + codigoEnfermeiro + "\r\n" 
						+ "VacinaRecebida: " + vacinaRecebida.getNome() + " - Dose única" + "\r\n" 
							+ "Data da primeira dose: " + getDataPrimeira() + "\r\n" 
									+ super.toString();
			}else {
				return super.toString();
			}
		}else {
			return "Código do Enfermeiro atendente: " + codigoEnfermeiro + "\r\n" 
					+ super.toString();
		}
	}

	public int getCodigoEnfermeiro() {
		return codigoEnfermeiro;
	}

	public void setDatas(Paciente pacienteExpecifico) {
		
		this.dataPrimeira = LocalDate.now();
		if(pacienteExpecifico.getVacinaRecebida().getDosesPorPaciente() > 1) {
			this.dataRetorno = LocalDate.now().plusMonths(3);
		}
	}

	
	public String getDataRetorno() {
		return dataRetorno.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public LocalDate getDataRetornoInterna() {
		return dataRetorno;
	}
	
	public String getDataPrimeira() {
		return dataPrimeira.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public void setVacinaRecebida(Vacina vacinaRecebida) {
		this.vacinaRecebida = vacinaRecebida;
	}

}
