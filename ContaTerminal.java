package simulandoContaBancaria;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {

	public static void main(String[] args) {

		ContaBancaria cb = null;
		boolean ld = true;

		Scanner sc = new Scanner(System.in); 
		Locale.setDefault(Locale.ENGLISH);

		while (true) {
			try {

				System.out.println("Digite para:");
				System.out.println("1- Criar uma conta");
				System.out.println("2- Para acessar sua conta");
				int digito = sc.nextInt();
				sc.nextLine();

				if (digito == 1) {
					System.out.println("Digite seu nome: ");
					String nome = sc.nextLine();
					if (true) {
						while (true) {
							if (nome.matches("[A-Za-z ]+( [A-Za-z ]+)*")) {
								break;
							} else {
								System.out.println("Seu nome nao pode ter numeros e simbolos, somentes letras");
								System.out.println("digite novamente:");
								nome = sc.nextLine();
							}
						}
					}

					cb = new ContaBancaria();
					Contas listaDeContas = new Contas();
					listaDeContas.criarConta(cb, nome);

					while (true) {
						ArrayList<Character> letras = new ArrayList();
						ArrayList<Character> numeros = new ArrayList();
						ArrayList<Character> simbolos = new ArrayList();

						System.out.println("Digite sua senha:");
						String senha = sc.nextLine();
						for (char c : senha.toCharArray()) {
							if (Character.isLetter(c)) {
								letras.add(c);
							} else if (Character.isDigit(c)) {
								numeros.add(c);
							} else {
								simbolos.add(c);
							}

						}
						if (letras.size() >= 4 && numeros.size() >= 2 && simbolos.size() >= 2
								&& senha.matches("\\S+")) {
							cb.setSenha(senha);
							System.out.println("Senha criada com sucesso!!!");
							break;
						} else {
							System.out.println();
							System.out.println(
									"sua senha nao pode ter espaço e precisa ter pelo menos 8 digitos contendo 4 letras ,2 numeros e 2 simbolos...");
							System.out.println("Por favor tente novemente...");

						}

					}
					System.out.println("Olá " + cb.getNomeCliente()
							+ " , obrigado por criar uma conta em nosso banco, sua agência é " + cb.getAgencia()
							+ " , conta: " + cb.getNumero() + " saldo: " + cb.getSaldo()
							+ " já está disponível para saques e depsitos...");

					while (true) {

						try {
							System.out.println();
							System.out.println("Digite para...");
							System.out.println("1-Voutar ao inicio");
							System.out.println("2-Para realizar depositos");
							System.out.println("3-Para realizar saques");
							System.out.println();
							int saquesDepositos = sc.nextInt();

							if (saquesDepositos == 1) {
								break;
							}
							if (saquesDepositos == 2) {
								cb.depositar(cb);
							}
							if (saquesDepositos == 3) {
								cb.sacar(cb);
							}
							if (saquesDepositos <= 0 || saquesDepositos > 3) {
								System.out.println("Digito invalido, por favor digite novamente...");
							}
						} catch (InputMismatchException e) {
							System.out.println("Digito invalido, por favor digite somente numeros...");
							sc.nextLine();

						}

					}
				}

				if (digito == 2 && cb == null) {
					System.out.println("Voce ainda nao tem uma conta...");
					System.out.println("Por favor crie uma...");
					System.out.println();
				}

				if (digito == 2 && cb != null) {
					while (true) {
						try {
							System.out.println("Digite o numero da sua conta para poder acessá-la ");
							int numeroConta = sc.nextInt();
							int n = 0;
							int posicaoDoArray = 0;
							for (int i = 0; i < Contas.getConta().size(); i++) {
								if (Contas.getConta().get(i).getNumero() == numeroConta) {
									n = numeroConta;
									posicaoDoArray = i;
								}
							}
							if (n != 0) {
								System.out.println("Olá, " + Contas.getConta().get(posicaoDoArray).getNomeCliente());
								System.out.println();
								while (ld) {
									System.out.println("Por favor digite sua senha...");
									String senha = sc.next();
									if (Contas.getConta().get(posicaoDoArray).getSenha().equals(senha)) {
										System.out.println("senha correta!!!");
										System.out.println();
										System.out.println("Conta: " + Contas.conta.get(posicaoDoArray).getNumero());
										System.out.println(
												" Proprietario: " + Contas.conta.get(posicaoDoArray).getNomeCliente());
										System.out.println(" Saldo: " + Contas.conta.get(posicaoDoArray).getSaldo());
										System.out
												.println(" Agencia: " + Contas.conta.get(posicaoDoArray).getAgencia());
										while (true) {
											try {
												System.out.println();
												System.out.println("Digite para...");
												System.out.println("1-Voutar ao inicio");
												System.out.println("2-Para realizar depositos");
												System.out.println("3-Para realizar saques");
												System.out.println();
												int saquesDepositos = sc.nextInt();

												if (saquesDepositos == 1) {
													ld = false;
													break;
												}
												if (saquesDepositos == 2) {
													cb.depositar(cb);
												}
												if (saquesDepositos == 3) {
													cb.sacar(cb);
												}
												if (saquesDepositos <= 0 || saquesDepositos > 3) {
													System.out
															.println("Digito invalido, por favor digite novamente...");
												}

											} catch (InputMismatchException e) {
												System.out.println(
														"digito invalido,por favor digite somente numeros inteiros...");
												System.out.println();
												sc.nextLine();
											}
										}

									} else {
										System.out.println("Senha incorreta...");
										System.out.println();
									}
								}
							}
						} catch (InputMismatchException e) {
							System.out.println("digito invalido,por favor digite somente numeros inteiros...");
							sc.nextLine();
						}

						if (ld == false) {
							break;
						}
					}

				}
				if (digito <= 0 || digito > 2) {
					System.out.println("Digito invalido por favor tente novamente...");
					System.out.println();

				}
			} catch (InputMismatchException e) {
				System.out.println("digito invalido,por favor digite somente numeros inteiros...");
				System.out.println();
				sc.nextLine();
			}
		}
	}
}
