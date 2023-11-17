package aplicacao;

import java.util.Scanner;

import dao.AlunoDAO;
import dao.InscricaoDAO;
import dao.VagaDAO;
import model.Aluno;
import model.Inscricao;
import model.Vaga;

public class MainInscricao {
public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		InscricaoDAO inscricaoDAO = new InscricaoDAO();
		VagaDAO vagaDAO = new VagaDAO();
		AlunoDAO alunoDAO = new AlunoDAO();
		
		int opcao = 0, id = 0; 
		
		String  data_Inscricao = "", nome = "";
	   
	   

		
		do {
			
			System.out.println("\n============================== Compra =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				
				System.out.println("Digite a data da Inscriçao:");
				data_Inscricao = s.nextLine();
				System.out.println("Digite o nome da vaga:");
			    nome = s.nextLine();
				s.nextLine();
				System.out.println("Digite o id do Aluno:");
				int id_Aluno = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id da vaga:");
				int id_Vaga = s.nextInt();
				s.nextLine();
				
				Aluno aluno1 = alunoDAO.readById(id_Aluno);
				Vaga vaga1 = vagaDAO.readById(id_Vaga);
				
				Inscricao inscricao1 = new Inscricao(data_Inscricao, nome, aluno1, vaga1);
				
			inscricaoDAO.create(inscricao1);
				break;
			case 2:
				
				for (Inscricao u : inscricaoDAO.read()) {
					System.out.println(u.toString());
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id da Inscricao:");
				int id_Inscricao = s.nextInt();
				s.nextLine();
				System.out.println("Digite a data da Inscricao:");
				data_Inscricao = s.nextLine();
				System.out.println("Digite o nome da vaga:");
				nome = s.nextLine();
				s.nextLine();
				System.out.println("Digite o id do aluno:");
				int id_aluno1 = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id da vaga:");
				int id_vaga1 = s.nextInt();
				s.nextLine();
				
				Aluno aluno2 = alunoDAO.readById(id_aluno1);
				Vaga vaga2 = vagaDAO.readById(id_vaga1);
				
				
				Inscricao inscricao2 = new Inscricao(id_Inscricao, data_Inscricao, nome, aluno2, vaga2);
				
				inscricaoDAO.update(inscricao2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				inscricaoDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Inscricao inscricao3 = inscricaoDAO.readById(id);
				
				System.out.println(inscricao3.toString());
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}

	}


