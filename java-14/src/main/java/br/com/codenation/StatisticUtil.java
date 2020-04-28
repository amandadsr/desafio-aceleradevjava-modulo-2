package br.com.codenation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.FREE_MEM;

public class StatisticUtil {

	public static int average(int[] elements) {
		int media = 0;
		int soma = 0;

		for (int element : elements) {
			soma += element;
		}
		media = soma / elements.length;

		return media;
	}

	public static int mode(int[] elements) {

		HashMap<Integer, Integer> modaNum = new HashMap<Integer, Integer>();

		int qtdRepete = 0;
		int el = elements.length;
		int moda = 0;

		// percorre cada numero para ser comparado
		for (int i = 0; i < el - 1; i++) {

			// percorre a partir do numero consequente para comparar com o numero do indice
			// "i"
			for (int j = i; j < el - 1; j++) {

				// se os numeros forem iguais acrescenta na TreeMap
				if (elements[i] == elements[j + 1]) {
					moda = elements[i];

					if (!modaNum.containsKey(moda)) {
						qtdRepete = 0;
					}

					qtdRepete++;

					modaNum.put(moda, qtdRepete+1);
					
				}
			}
		}

	
		return modaNum.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();

		
	}

	public static int median(int[] elements) {
		int metade;
		int mediana;

		List<Integer> list = new ArrayList<>();
		
		for (int element : elements) {
			list.add(element);
		}
		Collections.sort(list);
		
		/*if (elements.length % 2 == 0) { // é par
			metade = elements.length / 2;
			mediana = elements[metade - 1] + elements[metade];

		} else { // é impar
			metade = elements.length / 2;
			mediana = elements[metade];
		}*/
		
		if(list.size() % 2 == 0) {// é par
			metade = list.size() / 2;
			mediana = (list.get(metade-1) + list.get(metade))/2;
			
		}else {// é impar
			metade = list.size() / 2;
			mediana = list.get(metade);
		}
		
		
		return mediana;
	}
}