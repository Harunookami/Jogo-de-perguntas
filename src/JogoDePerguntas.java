import java.util.Scanner;

public class JogoDePerguntas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String Krypton = "Krypton";
        String fogoesangue = "Fogo e Sangue";
        String AssassinsCreed = "Ezio Auditore";
        String batman = "Bruce Wayne";
        int BackToTheFuture = 1955;


        String resposta = "resposta";
        boolean continuar = true;
        int pontos = 0;

            System.out.println("===== Bem-vindo ao Jogo de Perguntas =====");

            while(continuar){
                System.out.println("Escolha uma opção: ");
                System.out.println("1 - Iniciar jogo");
                System.out.println("2 - Como jogar");
                System.out.println("3 - Sair");
                int opcao = sc.nextInt();
                sc.nextLine();

                switch(opcao){
                    case 1:
                        boolean todasPerguntasRespondidas = true;

                        while (!resposta.equalsIgnoreCase("Krypton")) {
                            System.out.println("Qual é o nome do planeta natal de Superman?");
                            resposta = sc.nextLine().trim();

                            if (resposta.equalsIgnoreCase("pular")) {
                                System.out.println("Você pulou está pergunta!");
                                todasPerguntasRespondidas = false;
                                break;
                            }

                            if (!resposta.equalsIgnoreCase("Krypton")) {
                                System.out.println("Você errou! Tente novamente!");
                            } else {
                                System.out.println("Resposta correta. Parabéns! :) ");
                                pontos++;
                            }
                        }

                        resposta = "";

                        while (!resposta.equalsIgnoreCase("Fogo e Sangue")) {
                            System.out.println("Qual o lema da casa Targaryen de Game Of Thrones?");
                            resposta = sc.nextLine().trim();

                            if (resposta.equalsIgnoreCase("pular")) {
                                System.out.println("Você pulou está pergunta!");
                                todasPerguntasRespondidas = false;
                                break;
                            }


                            if (!resposta.equalsIgnoreCase("Fogo e Sangue")) {
                                System.out.println("Você errou! Tente novamente!");
                            } else {
                                System.out.println("Resposta correta! Você acertou novamente, parabéns!!");
                                pontos++;
                            }
                        }

                        resposta = "";

                        while (!resposta.equalsIgnoreCase("Ezio Auditore")) {
                            System.out.println("Qual o nome do protagonista de Assassins creed II?" );
                            resposta = sc.nextLine().trim();

                            if (resposta.equalsIgnoreCase("pular")) {
                                System.out.println("Você pulou está pergunta!");
                                todasPerguntasRespondidas = false;
                                break;
                            }


                            if (!resposta.equalsIgnoreCase("Ezio Auditore")) {
                                System.out.println("Você errou! Tente novamente!");
                            } else {
                                System.out.println("Resposta correta. Parabéns!");
                                pontos++;
                            }
                        }

                        resposta = "";
                        while (!resposta.equalsIgnoreCase("Bruce Wayne")) {
                            System.out.println("Qual o verdadeiro nome do Batman?");
                            resposta = sc.nextLine().trim();

                            if (resposta.equalsIgnoreCase("pular")) {
                                System.out.println("Você pulou está pergunta!");
                                todasPerguntasRespondidas = false;
                                break;
                            }


                            if (!resposta.equalsIgnoreCase("Batman")) {
                                System.out.println("Você errou! Tente novamente!");
                            } else {
                                System.out.println("Resposta correta. Parabéns, você acertou novamente!! :D");
                                pontos++;
                            }
                        }

                        resposta = "";

                        while (!resposta.equalsIgnoreCase("1955")) {
                            System.out.println("Em De Volta para o Futuro, qual é o ano para qual Marty McFly viaja pela primeira vez?");
                            resposta = sc.nextLine().trim();

                            if (resposta.equalsIgnoreCase("pular")) {
                                System.out.println("Você pulou está pergunta!");
                                todasPerguntasRespondidas = false;
                                break;
                            }


                            if (!resposta.equalsIgnoreCase("1955")) {
                                System.out.println("Resposta errada. Tente novamente!");
                            } else {
                                System.out.println("Resposta correta. Parabéns!");
                                pontos++;
                            }
                        }

                        System.out.println("Parabéns, você acertou todas as perguntas!");
                        System.out.println("Sua pontuação final é: " + pontos);

                        if (todasPerguntasRespondidas) {
                            continuar = false;
                            System.out.println("Você completou o jogo. Até a próxima.");
                        }
                        break;

                    case 2:
                        System.out.println("Como jogar:");
                        System.out.println("1. Você será apresentado a uma série de perguntas.");
                        System.out.println("2. Digite a resposta correta para cada pergunta.");
                        System.out.println("3. Se você quiser pular uma pergunta, digite 'pular'.");
                        System.out.println("4. O jogo continuará até que todas a perguntas sejam respondidas.");
                        break;

                    case 3:
                        System.out.println("Saindo do jogo. Até a próxima!");
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }

            }
        sc.close();
    }




}


        

