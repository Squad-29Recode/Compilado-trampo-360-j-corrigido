package aplicacao;

import java.util.Scanner;

import dao.AlunoDAO;
import dao.AquisicaoDAO;
import dao.EventoDAO;
import model.Aluno;
import model.Aquisicao;
import model.Evento;

public class MainAquisicao {
public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		AquisicaoDAO aquisicaoDAO = new AquisicaoDAO();
		EventoDAO eventoDAO = new EventoDAO();
		AlunoDAO alunoDAO = new AlunoDAO();
		
		int opcao = 0, id = 0; 
		
		String  data_Aquisicao = "", nome = "";
	   
	   

		
		do {
			
			System.out.println("\n============================== Compra =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				
				System.out.println("Digite a data de Aquisição:");
				data_Aquisicao = s.nextLine();
				System.out.println("Digite o nome do evento:");
			    nome = s.nextLine();
				s.nextLine();
				System.out.println("Digite o id do Aluno:");
				int id_Aluno = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do evento:");
				int id_Evento = s.nextInt();
				s.nextLine();
				
				Aluno aluno1 = alunoDAO.readById(id_Aluno);
				Evento evento1 = eventoDAO.readById(id_Evento);
				
				Aquisicao aquisicao1 = new Aquisicao(data_Aquisicao, nome, aluno1, evento1);
				
			aquisicaoDAO.creat(aquisicao1);
				break;
			case 2:
				
				for (Aquisicao u : aquisicaoDAO.read()) {
					System.out.println(u.toString());
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id da aquisicao:");
				int id_Aquisicao = s.nextInt();
				s.nextLine();
				System.out.println("Digite a data da aquisicao:");
				data_Aquisicao = s.nextLine();
				System.out.println("Digite o nome do Evento:");
				nome = s.nextLine();
				s.nextLine();
				System.out.println("Digite o id do aluno:");
				int id_aluno1 = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id da vaga:");
				var id_vaga1 = s.nextInt();
				s.nextLine();
				
				Aluno aluno2 = alunoDAO.readById(id_aluno1);
				int id_Evento1 = 0;
				Evento evento2 = eventoDAO.readById(id_Evento1);
				
				
				Aquisicao aquisicao2 = new Aquisicao(id_Aquisicao, data_Aquisicao, nome, aluno2, evento2);
				
				aquisicaoDAO.update(aquisicao2);
				break;
			case 4:
				System.out.println("Digite o id da aquisicao:");
				id = s.nextInt();
				s.nextLine();
				
				AquisicaoDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Aquisicao aquisicao3 = aquisicaoDAO.readById(id);
				
				System.out.println(aquisicao3.toString());
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}

	}


