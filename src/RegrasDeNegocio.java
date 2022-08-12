import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class RegrasDeNegocio {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner leia = new Scanner(System.in);
		Cliente cliente = new Cliente();
		Carro carro = new Carro();
		List<Cliente> aprovados = new ArrayList<>();

		int voltar = 1;
		cliente.setValidacao(false);
		String nomeUsuario = "";
		String senhaUsuario = "";
		String usuario = "admin";
		String senha = "admin";
		do { // Principal pro codigo retornar ao terminar

			while (cliente.isValidacao() == false) {
				System.out.println("---------------------------------------");
				System.out.println("Bem vindo a concession�ria LG ve�culos!");

				System.out.println("1 - login");
				System.out.println("2 - Ver nossos carros");
				System.out.print("\nDigite sua op��o para prosseguir: ");
				String inicio;
				try {
					inicio = leia.next();
					inicio = inicio.replaceAll("[^\\d]", "");
					cliente.setEscolha(Integer.parseInt(inicio));
					cliente.setValidacao(true);

				} catch (InputMismatchException e1) {
					System.out.println("\nEscolha somente as op��es dispon�veis.");
					cliente.setValidacao(false);
				} catch (NumberFormatException e1) {
					System.out.println("\nEscolha somente as op��es dispon�veis.");
					cliente.setValidacao(false);
				}
			} // } while (cliente.isValidacao() == false);
			if (cliente.getEscolha() == 1) { // PRINCIPAL

				do {
					if (nomeUsuario.equalsIgnoreCase(usuario) && senhaUsuario.equalsIgnoreCase(senha)) {
						cliente.setValidacao(true);
						break;
					}

					System.out.println("---------------------------------------");
					System.out.println("(Usu�rio : admin) - (Senha : admin)");
					System.out.println("Digite o login corretamente!");
					System.out.println();
					System.out.print("Digite seu login: ");
					nomeUsuario = leia.next().toLowerCase();
					System.out.print("Digite sua senha: ");
					senhaUsuario = leia.next();

					if (nomeUsuario.equalsIgnoreCase(usuario) && senhaUsuario.equalsIgnoreCase(senha)) {
						cliente.setValidacao(true);
					} else {
						System.out.println("\nAcesso negado!");
						cliente.setValidacao(false);
					}
				} while (cliente.isValidacao() == false);

				if (cliente.isValidacao() == true) {
					cliente.setValidacao(false);
					while (cliente.isValidacao() == false) {
						System.out.println("---------------------------------------");
						System.out.println("Bem vindo ADM ao acesso privado!\n");
						System.out.println("1 - Cadastrar clientes");
						System.out.println("2 - Ver clientes cadastrados");
						System.out.println("3 - Remover clientes");
						System.out.println("4 - Voltar");
						System.out.print("\nQual sua op��o? : ");
						try {
							String opcaoLogin = leia.next();
							opcaoLogin = opcaoLogin.replaceAll("[^\\d]", "");
							cliente.setEscolha(Integer.parseInt(opcaoLogin));
							cliente.setValidacao(true);

						} catch (NumberFormatException e) {
							System.out.println("\nEscolha somente as op��es dispon�veis.");
							cliente.setValidacao(false);
						}
					}

					if (cliente.getEscolha() == 1) { // Escolha 1 dentro do login
						cliente.setValidacao(false);
						do {
							System.out.println("---------------------------------------");
							System.out.println("Bem, vamos come�ar o cadastro do cliente.");
							System.out.print("Digite o nome do cliente : ");

							try {
								// leia.nextLine();
								String nome = leia.nextLine(); // LOUCURA TOTAL
								nome = leia.nextLine(); // LOUCURA TOTAL
								System.out.println(nome);
								boolean nomeValidacao = nome.matches("[A-Za-z������������������������������� ]{3,}$"); // DEFINIR
																														// QUANTIDADE!
								cliente.setNomeDeUsuario(nome);

								if (nomeValidacao == true) {
									cliente.setValidacao(true);
								} else {

									System.out.println("(Nome s� pode conter letras! No m�nimo 3 letras.)");
									cliente.setValidacao(false);
								}

							} catch (Exception e) {
								System.out.println("O nome n�o pode conter n�meros!");

							}
						} while (cliente.isValidacao() == false);

						do {
							System.out.print("\nDigite a idade do cliente : ");

							try {

								String idade = leia.next();
								idade = idade.replaceAll("[^\\d]", "");
								cliente.setIdade(Integer.parseInt(idade));

								if (cliente.getIdade() < 18 || cliente.getIdade() > 120) {
									System.out.println("Ponha uma idade valida! (S� aceitamos entre 18 e 120)");
									cliente.setValidacao(false);

								} else {
									cliente.setValidacao(true);
								}
							}

							catch (Exception e) {
								if (cliente.getIdade() < 0 || cliente.getIdade() > 120)
									System.out.println("Ponha uma idade real!");
								cliente.setValidacao(false);

							}
						} while (cliente.isValidacao() == false);

						System.out.println("\nSeu CPF (Fict�cio): " + cliente.getCPF());

						System.out.println("---------------------------------------------------");
						System.out.println(
								"\n- A pontua��o Score abaixo de 300 � muito dif�cil conseguir um financiamento.");
						System.out.println("\n- A pontua��o entre 300 & 700 � prov�vel que consiga um financiamento!");
						System.out.println(
								"\n- A pontua��o acima de 700 at� 1000, � quase certeza conseguir. Boa sorte!");

						do {
							System.out.print("\nQual o sua pontua��o Score? : ");

							try {
								String score = leia.next();
								score = score.replaceAll("[^\\d.]", "");
								cliente.setScore(Integer.parseInt(score));

								if (cliente.getScore() >= 0 && cliente.getScore() <= 300) {
									System.out.println("\nInfelizmente voc� n�o foi aprovado, tente daqui uns meses.");
									cliente.setAprovado(false);
									cliente.setValidacao(true);
								} else if (cliente.getScore() > 300 && cliente.getScore() < 700) {
									System.out
											.println("\nScore n�o t�o alto, por�m podemos dar in�cio a uma simula��o!");
									cliente.setAprovado(true);
									cliente.setValidacao(true);
								} else if (cliente.getScore() >= 700 && cliente.getScore() <= 1000) {
									System.out.println(
											"\nScore muito bom! Vamos dar in�cio imediatamente a nossa simula��o!");
									cliente.setAprovado(true);
									cliente.setValidacao(true);
								}

								else if (cliente.getScore() > 1000 || cliente.getScore() < 0) {
									System.out.println("\nPonha um score valido por favor!");
									cliente.setValidacao(false);
								}
							} catch (NumberFormatException e) {
								System.out.println("Ponha um score valido por favor! (Entre 0-1000)");
								cliente.setValidacao(false);
							} catch (InputMismatchException e) {
								System.out.println("S� pode colocar n�meros como op��o!");
								cliente.setValidacao(false);
							}
						} while (cliente.isValidacao() == false && cliente.isAprovado() == false);

						if (cliente.isAprovado() == true) {

							System.out.println("---------------------------------------------------");
							System.out.println("1 - Honda Civic 2022 - 128 mil Reais");
							System.out.println("2 - Honda Fit 2021 - 85 mil Reais");
							System.out.println("3 - Honda HR-V 2022 - 145 mil Reais");
							System.out.println("4 - Honda City 2023 - 120 mil Reais\n");
							do {
								System.out.print("Qual carro voc� deseja financiar? : ");
								try {
									String escolha = leia.next();
									escolha = escolha.replaceAll("[^\\d]", "");
									cliente.setValorDesejado(Integer.parseInt(escolha));
									cliente.setValidacao(true);

								} catch (InputMismatchException e) {
									System.out.println("S� pode colocar a op��o dispon�vel");
									cliente.setValidacao(false);
								} catch (NumberFormatException e) {
									System.out.println("S� pode colocar a op��o dispon�vel");
									cliente.setValidacao(false);
								}

								if (cliente.getValorDesejado() == 1) {
									carro.setNome(TipoCarro.HONDA_CIVIC_2022);
									carro.setPreco(128000);
									System.out.println(carro.toString());
									cliente.setValidacao(true);
								}
								if (cliente.getValorDesejado() == 2) {
									carro.setNome(TipoCarro.HONDA_FIT_2021);
									carro.setPreco(85000);
									System.out.println(carro.toString());
									cliente.setValidacao(true);
								}
								if (cliente.getValorDesejado() == 3) {
									carro.setNome(TipoCarro.HONDA_HR_V_2022);
									carro.setPreco(145000);
									System.out.println(carro.toString());
									cliente.setValidacao(true);
								}
								if (cliente.getValorDesejado() == 4) {
									carro.setNome(TipoCarro.HONDA_CITY_2023);
									carro.setPreco(120000);
									System.out.println(carro.toString());
									cliente.setValidacao(true);
								} else if (cliente.getValorDesejado() < 1 || cliente.getValorDesejado() > 4) {
									System.out.println("Invalido sua op��o!\n");
									cliente.setValidacao(false);

								}

							} while (cliente.isValidacao() == false);

							System.out.print("Quanto sera sua entrada? : ");
							double entrada = leia.nextDouble();
							carro.setEntrada(entrada);

							double valorAposEntrada = carro.setPreco(carro.getPreco() - carro.getEntrada());

							double juros1 = 1.24;
							double valor1 = valorAposEntrada / 24;
							double total1 = valor1 * juros1;
							System.out.printf("\nTemos em 24x de R$%.1f ", total1);

							double juros2 = 1.28;
							double valor2 = valorAposEntrada / 36;
							double total2 = valor2 * juros2;
							System.out.printf("\nTemos em 36x de R$%.1f ", total2);

							double juros3 = 1.32;
							double valor3 = valorAposEntrada / 48;
							double total3 = valor3 * juros3;
							System.out.printf("\nTemos em 48x de R$%.1f ", total3);

							double juros4 = 1.38;
							double valor4 = valorAposEntrada / 60;
							double total4 = valor4 * juros4;
							System.out.printf("\nTemos em 60x de R$%.1f \n", total4);

							do {
								do {
									System.out.print("\nQual � a sua renda? : ");
									try {
										String renda = leia.next();
										renda = renda.replaceAll("[^\\d.]", "");
										cliente.setRenda(Double.parseDouble(renda));

										if (cliente.getRenda() >= total4 || cliente.getRenda() <= 100000) {
											cliente.setAprovado(true);
											cliente.setValidacao(true);
										}
										if (cliente.getRenda() > 100000) {
											System.out.println("\nValor acima demais da m�dia nacional.");
											cliente.setAprovado(false);
											cliente.setValidacao(true);
										} else if (cliente.getRenda() < 2000) {
											System.out.println("Renda abaixo do que o necess�rio para prosseguirmos.");
											System.out.println("Tente novamente com uma renda complementar!");
											cliente.setAprovado(false);
											cliente.setValidacao(false);
										}

									} catch (NumberFormatException e) {
										System.out.println("Ponha uma renda verdadeira!");
										cliente.setValidacao(false);
										cliente.setAprovado(false);
									}

									if (cliente.isAprovado() == true) {
										System.out.println("\nVamos analisar se sua renda � compat�vel...");

										double trinPorc = 0.3;
										if (trinPorc * cliente.getRenda() > total4) {
											System.out.println("Voc� foi aprovado!");
											cliente.setValidacao(true);
											cliente.setAprovado(true);
										} else {
											System.out.println(
													"Infelizmente n�o foi dessa vez... Tente com uma renda maior!");
											cliente.setValidacao(false);
											cliente.setAprovado(false);
										}
									} else {

									}
								} while (cliente.isValidacao() == false);
							} while (cliente.isValidacao() == false);

							if (cliente.isAprovado() == true) {
								do {
									do {
										System.out.println("\nTemos em 24, 36, 48 e 60 meses");
										System.out.print("\nQuantas vezes voc� quer: ");
										double trinPorc = 0.3;

										String vezes = leia.next();
										vezes = vezes.replaceAll("[^\\d]", "");
										cliente.setEscolha(Integer.parseInt(vezes));

										if (cliente.getEscolha() == 24) {
											if (trinPorc * cliente.getRenda() > total1) {
												System.out.println("Voc� conseguio seu financiamento! Parab�ns!");
												Cliente cliente1 = new Cliente(cliente.getNomeDeUsuario(),
														cliente.getIdade(), cliente.getScore(), cliente.getRenda(), carro.getNome());
												aprovados.add(cliente1);
												cliente.setValidacao(true);
												break;
											} else {
												System.out.println(
														"Tente uma parcela maior! Valor maior que 30% da sua renda.");
												cliente.setValidacao(false);
											}
										}
										if (cliente.getEscolha() == 36) {
											if (trinPorc * cliente.getRenda() > total2) {
												System.out.println("Voc� conseguio seu financiamento! Parab�ns!");
												Cliente cliente1 = new Cliente(cliente.getNomeDeUsuario(),
														cliente.getIdade(), cliente.getScore(), cliente.getRenda(), carro.getNome());
												aprovados.add(cliente1);
												cliente.setValidacao(true);
												break;
											} else {
												System.out.println(
														"Tente uma parcela maior! Valor maior que 30% da sua renda.");
												cliente.setValidacao(false);
											}
										}
										if (cliente.getEscolha() == 48) {
											if (trinPorc * cliente.getRenda() > total3) {
												System.out.println("Voc� conseguio seu financiamento! Parab�ns!");
												Cliente cliente1 = new Cliente(cliente.getNomeDeUsuario(),
														cliente.getIdade(), cliente.getScore(), cliente.getRenda(), carro.getNome());
												aprovados.add(cliente1);
												cliente.setValidacao(true);
												break;
											} else {
												System.out.println(
														"Tente uma parcela maior! Valor maior que 30% da sua renda.");
												cliente.setValidacao(false);
											}
										}
										if (cliente.getEscolha() == 60) {
											if (trinPorc * cliente.getRenda() > total4) {
												System.out.println("\nVoc� conseguio seu financiamento! Parab�ns!");
												Cliente cliente1 = new Cliente(cliente.getNomeDeUsuario(),
														cliente.getIdade(), cliente.getScore(), cliente.getRenda(), carro.getNome());
												aprovados.add(cliente1);
												cliente.setValidacao(true);
												// cliente.setEscolha(1);
												break;

											} else {
												System.out.println(
														"Tente uma parcela maior! Valor maior que 30% da sua renda.");
												cliente.setValidacao(false);
											}
										} else {

											cliente.setValidacao(false);
										}
									} while (cliente.isValidacao() == false);
								} while (cliente.isValidacao() == false);

							}
						}
						cliente.setValidacao(true);
						cliente.setEscolha(1);

					} else if (cliente.getEscolha() == 2) { // Escolha 2 dentro do Login
						// do {
						if (aprovados.size() > 0) {
							System.out.println("\nTotal de clientes aprovados s�o: " + aprovados.size());
							aprovados.stream().forEach(System.out::println);
						} else {
							System.out.println("\nSem clientes no momento!");

						}
						cliente.setValidacao(true);
						cliente.setEscolha(1);
						continue;

						// } while (cliente.isValidacao() == true);

					} else if (cliente.getEscolha() == 3) { // op��o 3 dentro do login
						do {
							if (aprovados.size() > 0) {
								System.out.println(
										"\nSe deseja realmente excluir um cliente s� selecionar a op��o correspondente.");
								aprovados.stream().forEach(System.out::println);
								System.out.print("Qual deseja remover? : ");
								int remover;
								try {
									remover = leia.nextInt();
									aprovados.remove(remover - 1);
									cliente.setValidacao(true);
									cliente.setEscolha(1);
								} catch (Exception e) {
									System.out.println("Apenas clientes v�lidos.");
									cliente.setValidacao(false);
								}

							} else {
								System.out.println("\nImposs�vel remover o que n�o existe.");
								cliente.setValidacao(true);
								cliente.setEscolha(1);

							}

						} while (cliente.isValidacao() == false);
					} else {// Fim do programa principal
						cliente.setValidacao(false);
						nomeUsuario = "";
						senhaUsuario = "";
					}
					continue;

				}
			}
			if (cliente.getEscolha() == 2) { // PRINCIPAL
				System.out.println("\n=======================================");
				System.out.println("1 - Honda Civic 2022 - 128 mil Reais");
				System.out.println("\nConsumo na cidade:");
				System.out.println();
				System.out.println("Consome 7,1 km/litro no etanol");
				System.out.println("Consome 10,2 km/litro na gasolina");
				System.out.println("\nConsonme na estrada: ");
				System.out.println();
				System.out.println("Consume 9,3 km/litro no etanol");
				System.out.println("Consome 13,4 km/litro na gasolina");

				System.out.println("\n=======================================");
				System.out.println("2 - Honda Fit 2021 - 85 mil Reais");
				System.out.println("\nConsumo na cidade:");
				System.out.println();
				System.out.println("Consome 11,6 km/litro no etanol");
				System.out.println("Consome 12,3 km/litro na gasolina");
				System.out.println("\nConsumo na estrada: ");
				System.out.println();
				System.out.println("Consome 13,6 km/litro no etanol");
				System.out.println("Consome 14,1 km/litro na gasolina");

				System.out.println("\n=======================================");
				System.out.println("3 - Honda HR-V 2022 - 145 mil Reais");
				System.out.println("\nConsumo na cidade:");
				System.out.println();
				System.out.println("Consume 7,7 km/litro no etanol");
				System.out.println("Consuimo 11 km/litro na gasolina");
				System.out.println("\nConsumo na estrada: ");
				System.out.println();
				System.out.println("Consume 8,6 km/litro no etanol");
				System.out.println("Consome 12,3 km/litro na gasolina");

				System.out.println("\n=======================================");
				System.out.println("4 - Honda City 2023 - 120 mil Reais");
				System.out.println("\nConsumo na cidade:");
				System.out.println();
				System.out.println("Consome 9,1 km/litro no etanol");
				System.out.println("Consome 13,3 km/litro na gasolina");
				System.out.println("\nConsumo na estrada: ");
				System.out.println();
				System.out.println("Consume 10,5 km/litro no etanol");
				System.out.println("Consome 14,8 km/litro na gasolina");
				System.out.println();
				cliente.setValidacao(false);
			}
		} while (voltar == 1);

	}
}
