package view;

import java.util.Scanner;

import controller.CampeonatoMBean;
import controller.JogadorMBean;
import controller.TimeMBean;
import controller.TreinadorMBean;

public class App {

	private static Scanner input;

	public static void exibirMenu() {

		int option = 100;
		input = new Scanner(System.in);

		while (option != 0) {
			System.out.println("Informe a opção desejada: ");
			System.out.println("1 - Consultar Jogador");
			System.out.println("2 - Consultar Treinador");
			System.out.println("3 - Consultar Time");
			System.out.println("4 - Média de gols do campeonato");
			System.out.println("5 - Artilheiros do campeonato");
			System.out.println("6 - Consultar Classificação");
			System.out.println("7 - Consultar Histórico Atleta");
			System.out.println("8 - Jogadores por time");
			System.out.println("9 - Atualizar Jogador");
			System.out.println("10 - Cadastrar Jogador");
			System.out.println("0 - Sair");
			System.out.print("Opção: ");
			option = input.nextInt();

			switch (option) {

			case 1:
				JogadorMBean.consultarJogador();
				break;

			case 2:
				TreinadorMBean.consultarTreinador();
				break;

			case 3:
				TimeMBean.consultarTime();
				break;

			case 4:
				CampeonatoMBean.consultarMediaGols();
				break;

			case 5:
				CampeonatoMBean.consultarArtilheiros();
				break;
			case 6:
				CampeonatoMBean.consultarClassificacao();
				break;
				
			case 7:
				JogadorMBean.consultaHistoricoJogador();
				break;
				
			case 8:
				TimeMBean.jogadoresPorTime();
				break;
			
			case 9:
				JogadorMBean.atualizarJogador();
				break;
				
			case 10:
				JogadorMBean.cadastrarJogador();
				break;
				
			case 0:
				System.out.println(" \n" + "Até logo pessoal!!");
				break;

			default:
				break;
			}

		}

	}
}
