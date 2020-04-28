package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	List<Time> times = new ArrayList<>();
	List<Jogador> jogadores = new ArrayList<>();

	Integer minHabilidade = 0;
	Integer maxHabilidade = 100;

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
			String corUniformeSecundario) {
		if (validarIdTime(id)) {
			throw new IdentificadorUtilizadoException("Time: " + id + " ja existe!");
		} else {
			Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
			times.add(time);
		}
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade,
			BigDecimal salario) {

		if (validarIdJogador(id)) {
			throw new IdentificadorUtilizadoException("Jogador: " + id + " ja existe!");
		} else if (!validarIdTime(idTime)) {
			throw new TimeNaoEncontradoException("Time: " + idTime + " nao existe!");
		} else {
			Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
			jogadores.add(jogador);

			Time time = getTime(idTime);
			time.adicionarJogador(jogador);
		}
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {

		if (!validarIdJogador(idJogador)) {
			throw new JogadorNaoEncontradoException("Jogador: " + idJogador + " nao encontrado!");
		} else {
			Jogador capitao = getJogador(idJogador);
			Time capitaoTime = getTime(capitao.getIdTime());

			capitaoTime.setIdCapitao(idJogador);
		}
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {

		if (!validarIdTime(idTime)) {
			throw new TimeNaoEncontradoException("Time: " + idTime + " nao encontrado!");
		} else {

			Time time = getTime(idTime);

			if (time.getIdCapitao() == 0L) {
				throw new CapitaoNaoInformadoException("Capitao do time: " + idTime + " nao foi informado!");
			}

			return time.getIdCapitao();
		}

	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {

		String nomeJogador;
		if (!validarIdJogador(idJogador)) {
			throw new JogadorNaoEncontradoException("Jogador: " + idJogador + " nao encontrado!");
		} else {
			Jogador jogador = getJogador(idJogador);
			nomeJogador = jogador.getNome();

			return nomeJogador;
		}
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {

		String nomeTime;
		if (!validarIdTime(idTime)) {
			throw new TimeNaoEncontradoException("Time: " + idTime + " nao encontrado!");
		} else {
			Time time = getTime(idTime);
			nomeTime = time.getNome();

			return nomeTime;
		}
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {

		List<Jogador> list_Jogadores = new ArrayList<>();
		List<Long> list_Jogadores_Id = new ArrayList<>();

		if (!validarIdTime(idTime)) {
			throw new TimeNaoEncontradoException("Time: " + idTime + " nao encontrado!");
		} else {
			Time time = getTime(idTime);
			list_Jogadores = time.getJogadores();

			for (Jogador jogador : list_Jogadores) {

				list_Jogadores_Id.add(jogador.getId());

			}
			Collections.sort(list_Jogadores_Id);
			return list_Jogadores_Id;
		}
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		Integer valHabilidade = 0;
		Long melhorJogador = 0L;

		if (!validarIdTime(idTime)) {
			throw new TimeNaoEncontradoException("Time: " + idTime + " nao encontrado!");
		} else {
			Time time = getTime(idTime);
			List<Jogador> list = time.getJogadores();
			for (Jogador jogador : list) {

				if (jogador.getNivelHabilidade() > valHabilidade) {
					valHabilidade = jogador.getNivelHabilidade();
					melhorJogador = jogador.getId();
				} else if (jogador.getNivelHabilidade() == (valHabilidade)) {
					if (melhorJogador.equals(0L)) {
						melhorJogador = jogador.getId();
						valHabilidade = jogador.getNivelHabilidade();
					}
					if (jogador.getId() < melhorJogador) {
						melhorJogador = jogador.getId();
						valHabilidade = jogador.getNivelHabilidade();
					}
				}
			}

			return melhorJogador;
		}
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		Long mais_Velho = 0L;
		LocalDate idadeAnterior = LocalDate.now();

		if (!validarIdTime(idTime)) {
			throw new TimeNaoEncontradoException("Time: " + idTime + " nao encontrado!");
		} else {

			Time time = getTime(idTime);
			List<Jogador> list = time.getJogadores();

			for (Jogador jogador : list) {
				if (jogador.getDataNascimento().isBefore(idadeAnterior)) {
					mais_Velho = jogador.getId();
					idadeAnterior = jogador.getDataNascimento();
				} else if (jogador.getDataNascimento().isEqual(idadeAnterior)) {
					if (mais_Velho.equals(0L)) {
						mais_Velho = jogador.getId();
						idadeAnterior = jogador.getDataNascimento();
					}
					if (jogador.getId() < mais_Velho) {
						mais_Velho = jogador.getId();
						idadeAnterior = jogador.getDataNascimento();
					}
				}
			}
			return mais_Velho;
		}
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		List<Long> listIdTimes = new ArrayList<>();

		if (times.isEmpty())
			return new ArrayList<>();

		times.forEach(time -> listIdTimes.add(time.getId()));
		Collections.sort(listIdTimes);
		return listIdTimes;
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		BigDecimal maiorSalario = BigDecimal.valueOf(0.0);
		Long idMaiorSalario = 0L;

		if (!validarIdTime(idTime)) {
			throw new TimeNaoEncontradoException("Time: " + idTime + " nao encontrado!");
		} else {
			Time time = getTime(idTime);
			List<Jogador> list = time.getJogadores();
			for (Jogador jogador : list) {
				if ((jogador.getSalario().compareTo(maiorSalario)) > 0) {
					maiorSalario = jogador.getSalario();
					idMaiorSalario = jogador.getId();
				} else if ((jogador.getSalario().compareTo(maiorSalario)) == 0) {
					if (idMaiorSalario > jogador.getId()) {
						maiorSalario = jogador.getSalario();
						idMaiorSalario = jogador.getId();
					}
				}
			}

			return idMaiorSalario;
		}
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {

		if (!validarIdJogador(idJogador)) {
			throw new JogadorNaoEncontradoException("Jogador: " + idJogador + " nao encontrado!");
		} else {
			Jogador jogador = getJogador(idJogador);
			return jogador.getSalario();
		}
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {

		if (jogadores.isEmpty() || jogadores.size() == 0) {
			return new ArrayList<>();
		} else if (top < 0) {
			throw new IllegalArgumentException("Valor top não pode ser negativo");
		} else {
			List<Long> topJogadores = new ArrayList<>();

			topJogadores = jogadores.stream()
					.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed().thenComparing(Jogador::getId))
					.map(Jogador::getId).limit(top).collect(Collectors.toList());

			return topJogadores;
		}
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		
		if (!validarIdTime(timeDaCasa) || !validarIdTime(timeDeFora)) {
			throw new TimeNaoEncontradoException("1 ou 2 Times nao encontrados!");
		} else {
			Time timeCasa = getTime(timeDaCasa);
			Time timeFora = getTime(timeDeFora);

			String corPTimeCasa = timeCasa.getCorUniformePrincipal();

			String corPTimeFora = timeFora.getCorUniformePrincipal();
			String corSTimeFora = timeFora.getCorUniformeSecundario();

			if (corPTimeCasa.equalsIgnoreCase(corPTimeFora)) {
				return corSTimeFora;
			} else {
				return corPTimeFora;
			}
		}
	}

	public Boolean validarIdTime(Long id) {

		for (Time timeVerficacao : times) {
			if (timeVerficacao.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public Boolean validarIdJogador(Long id) {

		for (Jogador jogadorVerficacao : jogadores) {
			if (jogadorVerficacao.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	private Jogador getJogador(Long idJogador) {

		for (Jogador jogador : jogadores) {
			if (jogador.getId().equals(idJogador)) {
				Jogador get_Jogador = jogador;
				return get_Jogador;
			}
		}
		return null;
	}

	private Time getTime(Long idTime) {

		for (Time time : times) {
			if (time.getId().equals(idTime)) {
				Time get_Time = time;
				return get_Time;
			}
		}
		return null;
	}

}
