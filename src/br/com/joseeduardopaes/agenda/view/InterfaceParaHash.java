package br.com.joseeduardopaes.agenda.view;

import java.util.Scanner;

import br.com.joseeduardopaes.agenda.modelo.Contato;
import br.com.joseeduardopaes.agenda.modelo.ContatoDB;

public class InterfaceParaHash {

	private ContatoDB agenda = new ContatoDB();

	public void primeiroMenu() {
		int escolha;
		Scanner input = new Scanner(System.in);

		do {
			System.out.printf(
					"Digite uma das Opções:\n 1-AdicionarContato\n 2-PesquisarContato\n 3-MostrarContatos\n 4-Sair");
			escolha = input.nextInt();

			if (escolha == 1) {
				String nome;
				nome = this.perguntaParaUsuario("Digite o Primeiro do Contato:");
				String sobreNome;
				sobreNome = this.perguntaParaUsuario("Digite o Ultimo do Contato:");
				String telefone;
				telefone = this.perguntaParaUsuario("Digite o Telefone do Contato:");
				String eMail;
				eMail = this.perguntaParaUsuario("Digite o e-mail do Contato:");
				Contato contato = new Contato(nome, sobreNome, telefone, eMail);
				agenda.adicionarContatoHashMap(contato);
				System.out.println("Contato " + contato.toString() + " foi adicionado!");
				System.out.println("Você tem " + agenda.numeroDeContatosDoHashMap() + " Contatos.");
			} else if (escolha == 2) {
				String iniciais = this.perguntaParaUsuario("Digite as iniciais do contato:");
				this.menuDeBusca(agenda.buscarPorInicial(iniciais));
			} else if (escolha == 3) {
				agenda.organizaContatos();
				String lista = "=====Lista de Contatos=====";
				lista += agenda.mostrarContatoHashMap();
				lista += "\n===========================\nExistem " + agenda.numeroDeContatosDoHashMap() + " Contatos.";
				System.out.println(lista);
			} else if (escolha == 4) {

			} else {
				System.err.println("\n\n==Opção Inválida!!==\n\n");
			}

		} while (escolha != 4);

		input.close();
	}

	public void menuDeBusca(Contato contato) {
		int escolha;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		if (contato != null) {
			System.out.println(contato.toString());
			System.out.printf("Digite uma das Opções:\n 1-AlterarContato\n 2-RemoverContato\n 3-Sair");
			escolha = input.nextInt();

			if (escolha == 1) {
				this.menuDeAlteracao(contato);
			} else if (escolha == 2) {
				agenda.removerContato(contato);
				System.out.println("\n\n==Contato Removido Com Sucesso!!!==\n\n");
			} else if (escolha == 3) {

			} else {
				System.err.println("\n\n==Opção Inválida!!==\n\n");
			}
		} else {
			System.err.println("\n\n==Contato não econtrado!!==\n\n");
		}

	}

	public void menuDeAlteracao(Contato contato) {
		int escolha;

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.printf(
				"Digite uma das Opções:\n 1-Alterar PrimeiroNome\n 2-Alterar UltimoNome\n 3-Alterar Telefone\n 4-Alterar E-mail\n 5-Sair");
		escolha = input.nextInt();

		if (escolha == 1) {
			String nome;
			nome = this.perguntaParaUsuario("Digite o primerio nome do Contato:");
			this.alterarPrimeiroNome(contato, nome);
		} else if (escolha == 2) {
			String sobreNome;
			sobreNome = this.perguntaParaUsuario("Digite o ultimo nome do Contato:");
			this.alterarUltimoNome(contato, sobreNome);
		} else if (escolha == 3) {
			String telefone;
			telefone = this.perguntaParaUsuario("Digite o Telefone do Contato:");
			this.alterarTelefone(contato, telefone);
		} else if (escolha == 4) {
			String eMail;
			eMail = this.perguntaParaUsuario("Digite o e-mail do Contato: ");
			this.alterarEMail(contato, eMail);
		} else if (escolha == 5) {

		} else {
			System.err.println("\n\n==Comando Inválido!!!==\n\n");
		}

	}

	public void alterarPrimeiroNome(Contato contato, String nome) {
		contato.setPrimeiroNome(nome);
	}

	public void alterarUltimoNome(Contato contato, String nome) {
		contato.setUltimoNome(nome);
	}

	public void alterarTelefone(Contato contato, String Telefone) {
		contato.setNumeroDeTelefone(Telefone);
	}

	public void alterarEMail(Contato contato, String eMail) {
		contato.seteMail(eMail);
	}

	public String perguntaParaUsuario(String pergunta) {

		Scanner input = new Scanner(System.in);
		String resposta;

		System.out.printf(pergunta);
		resposta = input.nextLine();

		return resposta;

	}

}
