package main;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Locale; 

import pojo.*;
import dao.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventosDAO evenDAO = new EventosDAO();

		int option;
		Scanner scanner = new Scanner(System.in);
		scanner.useLocale(Locale.ENGLISH);
		boolean end = false;

		while(!end) {
			System.out.println("| 1 | Cadastrar eventos");
			System.out.println("| 2 | Listar todos os eventos");
			System.out.println("| 3 | Apagar um evento");
			System.out.println("| 4 | Atualizar evento cadastrado");
			System.out.println("| 0 | Sair");

			option = scanner.nextInt();
			scanner.nextLine();
	

			switch (option){
			case 1:{
				int id;
				String dia, nome, cidade, atracao;
				System.out.println("Digite o dia do evento:\n");
				dia = scanner.nextLine();
				System.out.println("Digite o nome do evento:\n");
				nome = scanner.nextLine();
				System.out.println("Digite a cidade:\n");
				cidade = scanner.nextLine();
				System.out.println("Digite a atracao:\n");
				atracao = scanner.nextLine();
				System.out.println("Digite o id do evento:\n");
				id = scanner.nextInt();
				
				Eventos eventos = new Eventos(java.sql.Date.valueOf(dia), id, nome, cidade, atracao);
				System.out.println(eventos.toString());
				if(evenDAO.addEventos(eventos)) {
					System.out.println("Inserido com sucesso!\n");
				}else {
					System.err.println("Erro ao inserir o usuário.\n");
				}
				break;
			
			}case 2:{
				ArrayList<Eventos> eventosList = evenDAO.getListEventos();
				for(Eventos eventos : eventosList){
					System.out.println(eventos.toString());
				}
				break;
			
				
			} case 3:{
				System.out.println("Digite o id do evento que deseja apagar:");
				int id = scanner.nextInt();
				if(evenDAO.deleteEventos(id)) {
					System.err.println("Usuário deletado com sucesso!\n");
				}else {
					System.err.println("Erro ao deletar o usuário.\n");
				}
				break;
			}case 4:{			
				int id;
				String dia, nome, cidade, atracao;
				System.out.println("Digite o dia do evento:\n");
				dia = scanner.nextLine();
				System.out.println("Digite o nome do evento:\n");
				nome = scanner.nextLine();
				System.out.println("Digite a cidade:\n");
				cidade = scanner.nextLine();
				System.out.println("Digite a atracao:\n");
				atracao = scanner.nextLine();
				System.out.println("Digite o id do evento:\n");
				id = scanner.nextInt();
				
				System.out.println("Digite o id do evento que deseja alterar:");
				id = scanner.nextInt();
				
				Eventos eventos = new Eventos(java.sql.Date.valueOf(dia), id, nome, cidade, atracao);
				if(evenDAO.altera(eventos)) {
					System.out.println("Atualizado com sucesso!");
				}else {
					System.err.println("Erro ao atualizar o usuário.");
				}
				break;
			}
			default:
				end = true;
				break;
			}
		}
	}

}

