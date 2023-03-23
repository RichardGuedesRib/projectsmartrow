package br.edu.fatec.projectsmartrow.application;

import java.util.Scanner;

import br.edu.fatec.projectsmartrow.model.Estabelecimento;
import br.edu.fatec.projectsmartrow.util.EstabelecimentoTeste;

public class PrincipalEstabelecimento {
	private static Estabelecimento estabelecimento = new Estabelecimento();
	EstabelecimentoTeste et = new EstabelecimentoTeste();
	Scanner sc = new Scanner(System.in);
	
	public void menuEstabelecimento() {
		estabelecimento = et.estabelecimentoteste();
		System.out.println("---------------------------------------------------------------");
		System.out.println("|                                                             |");
		System.out.println("|                    SMART ROW VERSAO 1.0                     |");
		System.out.println("|                                                             |");
		System.out.println("---------------------------------------------------------------");
		System.out.println("| USUARIO: " + estabelecimento + "--------------------------- |");
		System.out.println("---------------------------------------------------------------");
		System.out.println("|                  DIGITE A OPCAO DESEJADA                    |");
		System.out.println("---------------------------------------------------------------");
		System.out.println("| 1 - CADASTRAR NOVO ESTABELECIMENTO                          |");
		System.out.println("| 2 - BUSCAR ESTABELECIMENTO POR CNPJ                         |");
		System.out.println("| 3 - ALTERAR CADASTRO DE ESTABELECIMENTO                     |");
		System.out.println("| 3 - ADICIONAR CARDAPIO                                      |");
		System.out.println("| 4 - ADICIONAR MESA                                          |");
		System.out.println("| 5 - CONSULTAR FATURAMENTO                                   |");
		
		
		System.out.println("| 0 - SAIR                                                            |");		
		
		
		
	}
	

}