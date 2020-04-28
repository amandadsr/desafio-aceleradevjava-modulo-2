package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

	final int vagasCarrosEstac_MAX = 10;

	List<Carro> listaCarrosEstac = new ArrayList<>();

	public void estacionar(Carro carro) {

		verificarExcecoesMotorista(carro);

		//estacionamento com vagas
		if (carrosEstacionados() < vagasCarrosEstac_MAX) {
			listaCarrosEstac.add(carro);
			
		//estcionamento com todas as vagas ocupadas
		} else if (carrosEstacionados() == vagasCarrosEstac_MAX) {

			estacionamentoCheio(carro);

		}
	}

	public int carrosEstacionados() {
		return listaCarrosEstac.size();
	}

	public boolean carroEstacionado(Carro carro) {

		return listaCarrosEstac.contains(carro);
	}

	public void verificarExcecoesMotorista(Carro carro) {

		if (carro.getMotorista() == null) {
			throw new EstacionamentoException("Carro deve ter motorista!");
		}
		if (carro.getMotorista().getIdade() < 18) {
			throw new EstacionamentoException("Motorista nao pode ser menor de idade!");
		}
		if (carro.getMotorista().getPontos() > 20) {
			throw new EstacionamentoException("Motorista nao tem pontos!");
		}

	}

	public void estacionamentoCheio(Carro carro) {

		for (int indice = 0; indice < vagasCarrosEstac_MAX; indice++) {

			if (listaCarrosEstac.get(indice).getMotorista().getIdade() <= 55) {

				listaCarrosEstac.remove(indice);
				listaCarrosEstac.add(carro);
				break;

			} else {

				if (indice == 9) {
					throw new EstacionamentoException("Estacionamento Lotado!");
				}
			}
		}

	}

}
