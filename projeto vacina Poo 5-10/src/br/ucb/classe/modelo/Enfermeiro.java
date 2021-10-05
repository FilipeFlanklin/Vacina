package br.ucb.classe.modelo;

public class Enfermeiro extends Pessoa {

	private int codigo;

	public Enfermeiro(String nome, int idade, String cpf, int codigo, String endereco) {
		super(nome, idade, cpf, endereco);
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

}
