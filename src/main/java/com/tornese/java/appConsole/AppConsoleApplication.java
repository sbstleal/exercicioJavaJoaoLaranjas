package com.tornese.java.appConsole;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;
//import java.util.*;

@SpringBootApplication
public class AppConsoleApplication {

	public static void main(String[] args) {
		while (true) {
			Console cnsl = System.console();
			System.out.println("==============================");
			System.out.println("Seja bem-vindo Joao ao seu software");
			System.out.println("==============================");
			int sair = Integer.parseInt(cnsl.readLine("Digite \n1 - continuar \n0 - SAIR\n"));
			if (sair == 0){
				System.out.println("Tchazinho!!!");
				break;
			}
			System.out.println("==============================");

			int qtdLaranjaPorCaixa = 50;
			double valorLaranja = 0.50;
			// Console cnsl = System.console();
			// String qtdCaixas = cnsl.readLine("Digite a quantidade de caixas que você
			// pretende vender?\n");
			System.out.println("");
			int qtdCaixa = Integer.parseInt(cnsl.readLine("Digite a quantidade de caixas que voce pretende vender?\n"));

			int totalDeLaranjas = qtdCaixa * qtdLaranjaPorCaixa;
			double valorTotal = totalDeLaranjas * valorLaranja;
			double valorTotalAlterado = valorTotal;
			int porcentagemLucro = 40;
			int porcentagemDesconto = 10;
			int porcentagemAcrescimo = 15;
			int maximoParcelas = 12;
			int parcelas = 0;
			double valorParaDesconto = 100;
			int qtdCaixasPromocao = 3;

			String tipoPagamento = cnsl.readLine(
					"Você deseja pagar a vista ou parcelado?\n Digite a opçao desejada:\n A - à vista\n B - parcelado\n");

			boolean Avista = tipoPagamento.toUpperCase().equals("A");

			if (Avista) {
				System.out.println("Você selecionou o pagamento a vista.");
				if (valorTotal > valorParaDesconto || qtdCaixa >= qtdCaixasPromocao) {
					valorTotal -= (valorTotalAlterado * porcentagemDesconto / 100);
				}

			} else {
				parcelas = Integer.parseInt(
						cnsl.readLine("Você selecionou o pagamento a prazo, digite a quantidade de parcelas:\n"));
				if (parcelas > maximoParcelas) {
					System.out.println("Quantidade de parcelamento acima do permitido, iremos assumir em "
							+ maximoParcelas + " vezes.");
					parcelas = maximoParcelas;
				}

				if (parcelas == 1) {
					System.out.println("Você selecionou o pagamento a vista.");
					if (valorTotal > valorParaDesconto || qtdCaixa >= qtdCaixasPromocao) {
						valorTotal -= (valorTotalAlterado * porcentagemDesconto / 100);
					}
				}

				if (parcelas > 5) {
					valorTotalAlterado += (valorTotal * porcentagemAcrescimo / 100);
				} else {
					switch (parcelas) {
						case 2:
							porcentagemAcrescimo = 5;
							break;
						case 3:
							porcentagemAcrescimo = 8;
							break;
						case 4:
							porcentagemAcrescimo = 10;
							break;
						case 5:
							porcentagemAcrescimo = 13;
							break;
					}
					valorTotalAlterado += (valorTotal * porcentagemAcrescimo / 100);
				}
			}

			double lucroAReceber = (valorTotalAlterado * porcentagemLucro / 100);

			System.out.println("\n");
			System.out.println("==============================");
			System.out.println("Parabens pela venda!!!!!");
			System.out.println("==============================");
			System.out.println("O valor total a receber (cobrar do cliente) é R$" + valorTotalAlterado + ".");
			System.out.println("O valor do seu lucro é R$" + lucroAReceber + ".");

			System.out.print("O cliente escolheu o tipo de pagamento: ");
			if (Avista) {
				System.out.println("A vista.");
				System.out.println("Cobrar com desconto R$" + valorTotal + ".");
				System.out.println("Desconto de R$" + (valorTotal - valorTotalAlterado) + ".");
			}
			if (!Avista) {
				System.out.println("Parcelado.");
				System.out.println("Acrescimo de R$" + (valorTotalAlterado - valorTotal) + ".");
				System.out.println(
						"O valor da Parcela será de R$" + (valorTotalAlterado / parcelas) + " x " + parcelas + ".");
			}
			System.out.println("==============================");
		}
		// SpringApplication.run(AppConsoleApplication.class, args);
	}
}
