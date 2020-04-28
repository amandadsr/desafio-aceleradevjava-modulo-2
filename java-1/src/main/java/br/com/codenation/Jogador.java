package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {

	private Long id;
	private Long idTime;
	private String nome;
	private LocalDate dataNascimento;
	private Integer nivelHabilidade;
	private BigDecimal salario;

	public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade,
			BigDecimal salario) {
		setId(id);
		setIdTime(idTime);
		setNome(nome);
		setDataNascimento(dataNascimento);
		setNivelHabilidade(nivelHabilidade);
		setSalario(salario);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdTime() {
		return idTime;
	}

	public void setIdTime(Long idTime) {
		this.idTime = idTime;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.equals(null) || nome.isEmpty()) {
			throw new IllegalArgumentException("O nome deve ser informado");
		}
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		if (dataNascimento.equals(null)) {
			throw new IllegalArgumentException("A data deve ser informada");
		}
		this.dataNascimento = dataNascimento;
	}

	public Integer getNivelHabilidade() {
		return nivelHabilidade;
	}

	public void setNivelHabilidade(Integer nivelHabilidade) {
		if (nivelHabilidade.equals(null) || nivelHabilidade < 0 || nivelHabilidade > 100) {
			throw new IllegalArgumentException("O Nivel Habilidade deve ser informado ou é inválido");
		}
		this.nivelHabilidade = nivelHabilidade;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		if (salario.equals(null)) {
			throw new IllegalArgumentException("O salário deve ser informado ou é inválido");
		}
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Jogador [id=" + id + ", idTime=" + idTime + ", nome=" + nome + ", dataNascimento=" + dataNascimento
				+ ", nivelHabilidade=" + nivelHabilidade + ", salario=" + salario + "]";
	}

}
