
package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Teste {

	public static void main(String args[]) {
		final LocalDate NOW = LocalDate.from(LocalDateTime.now());
		DesafioMeuTimeApplication desafio = new DesafioMeuTimeApplication();

		
		 // Incluir Time 
		desafio.incluirTime(1L, "Time1",LocalDate.parse("1900-10-10"), "Preto", "Branco"); 
		desafio.incluirTime(3L,"Time3", LocalDate.parse("1891-12-11"), "Azul", "Vermelho");
		desafio.incluirTime(2L, "Time2", LocalDate.parse("1890-10-10"), "Amarelo","Vermelho");
	
		 // Incluir Jogador 
		 desafio.incluirJogador(6L, 1L, "Yago", LocalDate.parse("1988-05-01"), 100, BigDecimal.valueOf(100000.00));
		 desafio.incluirJogador(2L, 1L, "Valdívia", LocalDate.parse("1991-05-11"), 90, BigDecimal.valueOf(90000.00)); 
		 desafio.incluirJogador(3L, 1L, "Ramon", LocalDate.parse("1982-03-02"), 80, BigDecimal.valueOf(30000.00));
		 desafio.incluirJogador(4L, 1L, "Marcos", LocalDate.parse("1985-11-06"), 78, BigDecimal.valueOf(2000.00)); 
		 desafio.incluirJogador(10L, 1L, "Leandro",LocalDate.parse("1980-05-08"), 60, BigDecimal.valueOf(2200.00)); 
		 desafio.incluirJogador(1L, 1L, "Tiago", LocalDate.parse("1994-10-07"), 100, BigDecimal.valueOf(100000.00)); 
		 desafio.incluirJogador(7L, 1L, "Andrey", LocalDate.parse("2000-06-01"), 40, BigDecimal.valueOf(80000.00));
		 desafio.incluirJogador(8L, 1L, "Marrony", LocalDate.parse("1991-09-10"), 30, BigDecimal.valueOf(10000.00)); 
		 desafio.incluirJogador(9L, 1L, "Rosicley", LocalDate.parse("1992-07-12"), 20, BigDecimal.valueOf(36000.00));
		 desafio.incluirJogador(5L, 1L, "Werley", LocalDate.parse("1980-05-08"), 10, BigDecimal.valueOf(25000.00)); 
		 desafio.incluirJogador(11L, 1L, "Sidão", LocalDate.parse("1980-05-08"), 5, BigDecimal.valueOf(56000.00));
		  
		 desafio.incluirJogador(12L, 2L, "Gabriel", LocalDate.parse("1987-11-11"), 98, BigDecimal.valueOf(26000.00)); 
		 desafio.incluirJogador(13L, 2L, "Rafinha", LocalDate.parse("1995-09-26"), 99, BigDecimal.valueOf(20000.00));
		 desafio.incluirJogador(14L, 2L, "Diego", LocalDate.parse("1992-08-26"), 68, BigDecimal.valueOf(2100.00)); 
		 desafio.incluirJogador(15L, 2L, "Cuéllar", LocalDate.parse("1999-07-08"), 58, BigDecimal.valueOf(3300.00));
		 desafio.incluirJogador(19L, 2L, "Arrascaeta", LocalDate.parse("1998-06-19"), 48, BigDecimal.valueOf(56000.00)); 
		 desafio.incluirJogador(18L, 2L, "Bruno", LocalDate.parse("1997-02-17"), 38, BigDecimal.valueOf(8800.00));
		 desafio.incluirJogador(16L, 2L, "Rodrigo", LocalDate.parse("1996-11-22"), 28, BigDecimal.valueOf(28000.00)); 
		 desafio.incluirJogador(17L, 2L, "Éverton", LocalDate.parse("1994-12-30"), 18, BigDecimal.valueOf(7400.00));
		 desafio.incluirJogador(21L, 2L, "Victor", LocalDate.parse("1981-01-27"), 99, BigDecimal.valueOf(66300.00)); 
		 desafio.incluirJogador(20L, 2L, "Diego", LocalDate.parse("1980-12-10"), 97, BigDecimal.valueOf(51000.00));
		  
		 desafio.incluirJogador(12L, 3L, "Gabriel", LocalDate.parse("1987-11-11"), 98, BigDecimal.valueOf(26000.00)); 
		 desafio.incluirJogador(13L, 2L, "Rafinha", LocalDate.parse("1995-09-26"), 99, BigDecimal.valueOf(20000.00));
		 desafio.incluirJogador(14L, 2L, "Diego", LocalDate.parse("1992-08-26"), 68, BigDecimal.valueOf(2100.00)); 
		 desafio.incluirJogador(15L, 2L, "Cuéllar", LocalDate.parse("1999-07-08"), 58, BigDecimal.valueOf(3300.00)); 
		 desafio.incluirJogador(19L, 2L, "Arrascaeta", LocalDate.parse("1998-06-19"), 48, BigDecimal.valueOf(56000.00)); 
		 desafio.incluirJogador(18L, 2L, "Bruno", LocalDate.parse("1997-02-17"), 38, BigDecimal.valueOf(8800.00));
		 desafio.incluirJogador(16L, 2L, "Rodrigo", LocalDate.parse("1996-11-22"), 28, BigDecimal.valueOf(28000.00)); 
		 desafio.incluirJogador(17L, 2L, "Éverton", LocalDate.parse("1994-12-30"), 18, BigDecimal.valueOf(7400.00));
		 desafio.incluirJogador(21L, 2L, "Victor", LocalDate.parse("1981-01-27"), 99, BigDecimal.valueOf(66300.00)); 
		 desafio.incluirJogador(20L, 2L, "Diego", LocalDate.parse("1980-12-10"), 97, BigDecimal.valueOf(51000.00)); 
		 
		 // Definir Capitão 
		 desafio.definirCapitao(2L); // Time 1 
		 desafio.definirCapitao(20L); //Time 2
		  
		 // Buscar Capitão do Time System.out.println("Buscar Capitão do Time");
		 System.out.println(desafio.buscarCapitaoDoTime(1L)); // Time 1
		 System.out.println(desafio.buscarCapitaoDoTime(2L)); // Time 2
		 System.out.println();
		 
		 // Buscar Nome do Jogador System.out.println("Buscar Nome do Jogador");
		 System.out.println(desafio.buscarNomeJogador(3L)); // Time 1
		 System.out.println(desafio.buscarNomeJogador(19L)); // Time 2
		 System.out.println();
		  
		 // Buscar Nome do Time System.out.println("Buscar Nome do Time");
		 System.out.println(desafio.buscarNomeTime(1L)); // Time 1
		 System.out.println(desafio.buscarNomeTime(2L)); // Time 2
		 System.out.println();
		 
		 // Buscar Jogadores do Time System.out.println("Buscar Jogadores do Time");
		 System.out.println(desafio.buscarJogadoresDoTime(1L)); // Time 1
		 System.out.println(desafio.buscarJogadoresDoTime(2L)); // Time 2
		 System.out.println();
		 
		 // Buscar Melhor Jogador do Time
		 System.out.println("Buscar Melhor Jogador do Time");
		 System.out.println(desafio.buscarMelhorJogadorDoTime(1L)); // Time 1
		 System.out.println(desafio.buscarMelhorJogadorDoTime(2L)); // Time 2
		 System.out.println();
		 
		 // Buscar Jogador Mais Velho System.out.println("Buscar Jogador Mais Velho");
		 System.out.println(desafio.buscarJogadorMaisVelho(1L)); // Time 1
		 System.out.println(desafio.buscarJogadorMaisVelho(2L)); // Time 1
		 System.out.println();
		 
		 // Buscar Times System.out.println("Buscar Times");
		 System.out.println(desafio.buscarTimes()); System.out.println();
		  
		 // Buscar Maior Salário System.out.println("Buscar Maior Salário");
		 System.out.println(desafio.buscarJogadorMaiorSalario(1L)); // Time 1
		 System.out.println(desafio.buscarJogadorMaiorSalario(2L)); // Time 2
		 System.out.println();
		  
		 // Buscar Salário do Jogador System.out.println("Buscar Salário do Jogador");
		 System.out.println(desafio.buscarSalarioDoJogador(1L)); // Time 1
		 System.out.println(desafio.buscarSalarioDoJogador(2L)); // Time 2
		 System.out.println();
		 
		 // Buscar Tops Jogadores System.out.println("Buscar Tops Jogadores");
		 System.out.println(desafio.buscarTopJogadores(5)); // Time 1
		 System.out.println();
		 
		 // Buscar Cor da Camisa do Time de Fora
		 System.out.println("Buscar Cor da Camisa do Time de Fora");
		 System.out.println(desafio.buscarCorCamisaTimeDeFora(1L, 2L));
		 
	}
}
