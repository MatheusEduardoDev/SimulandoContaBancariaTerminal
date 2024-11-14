package simulandoContaBancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaBancaria {

	private int numero;
	private final String agencia = "397-5";
	private String nomeCliente;
	private double saldo;
	private Scanner sc = new Scanner(System.in);
	private String senha;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
		if (Contas.conta != null) {
			for (int i = 0; i < Contas.conta.size(); i++) {
				if (Contas.conta.get(i).getNumero() == this.numero) {
					int n = (int) Math.random() * 9999;
					Contas.conta.get(i).setNumero(n);
				}
			}
		}
	}

	public String getAgencia() {
		return agencia;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ContaBancaria() {
	}

	public void depositar(ContaBancaria cb) {
		while (true) {
			try {
				System.out.println("Digite um valor para o deposito:");
				double deposito = sc.nextDouble();
				if (deposito > 0) {
					this.saldo += deposito;
					System.out.println("Deposito realizado com sucesso!!!");
					System.out.println("Saldo atual: " + cb.getSaldo());
					System.out.println();
					break;
				} else {
					System.out.println("O valor inserido precisa ser maior do que zero... ");
				}
			} catch (InputMismatchException e) {
				System.out.println("Valor invalido, por favor digite somente numeros...");
				sc.nextLine();
			}
		}

	}

	public void sacar(ContaBancaria cb) {
		while (true) {
			try {
				System.out.println("Digite um valor para o saque:");
				double saque = sc.nextDouble();
				if (saque < cb.getSaldo() && saque > 0) {
					this.saldo -= saque;
					System.out.println("Saque realizado com sucesso!!!");
					System.out.println("Saldo atual: " + cb.getSaldo());
					System.out.println();
					break; 	
				} else {
					System.out.println("O valor inserido precisa ser maior do que zero e menor do o seu saldo: " + cb.getSaldo());
				}
			} catch (InputMismatchException e) {
				System.out.println("Valor invalido, por favor digite somente numeros...");
				sc.nextLine();
			}
		}

	}

}
