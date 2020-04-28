package br.com.codenation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Time {

	private Long id;
	private String nome;
	private LocalDate dataCriacao;
	private String corUniformePrincipal;
	private String corUniformeSecundario;
	
	private Long IdCapitao;

	private List<Jogador> jogadores;

	public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
			String corUniformeSecundario) {
		setId(id);
		setNome(nome);
		setDataCriacao(dataCriacao);
		setCorUniformePrincipal(corUniformePrincipal);
		setCorUniformeSecundario(corUniformeSecundario);
		setIdCapitao(0L);
		setJogadores(new ArrayList<>());
	}

	public Long getIdCapitao() {
		return IdCapitao;
	}

	public void setIdCapitao(Long idCapitao) {
		IdCapitao = idCapitao;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		
		this.id = id;
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

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		if (dataCriacao.equals(null)) {
			throw new IllegalArgumentException("A data deve ser informada");
		}
		this.dataCriacao = dataCriacao;
	}

	public String getCorUniformePrincipal() {
		return corUniformePrincipal;
	}

	public void setCorUniformePrincipal(String corUniformePrincipal) {
		if (corUniformePrincipal.equals(null) || corUniformePrincipal.isEmpty()) {
			throw new IllegalArgumentException("O cor do Uniforme principal deve ser informada");
		}
		this.corUniformePrincipal = corUniformePrincipal;
	}

	public String getCorUniformeSecundario() {
		return corUniformeSecundario;
	}

	public void setCorUniformeSecundario(String corUniformeSecundario) {
		if (corUniformeSecundario.equals(null) || corUniformeSecundario.isEmpty()) {
			throw new IllegalArgumentException("O cor do Uniforme secundário deve ser informada");
		}
		this.corUniformeSecundario = corUniformeSecundario;
	}

	public void adicionarJogador(Jogador jogador) {
		jogadores.add(jogador);
	}

	@Override
	public String toString() {
		return "Time [id=" + id + ", nome=" + nome + ", dataCriacao=" + dataCriacao + ", corUniformePrincipal="
				+ corUniformePrincipal + ", corUniformeSecundario=" + corUniformeSecundario + ", IdCapitao=" + IdCapitao
				+ ", jogadores=" + jogadores + "]";
	}

}
