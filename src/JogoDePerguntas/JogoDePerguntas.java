package JogoDePerguntas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class JogoDePerguntas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pergunta> perguntas = new ArrayList<>();

        perguntas.add(new Pergunta("Qual é o nome do planeta natal de Superman?", "Krypton"));
        perguntas.add(new Pergunta("Qual o lema da casa Targaryen de Game Of Thrones?", "Fogo e Sangue"));
        perguntas.add(new Pergunta("Qual o nome do protagonista de Assassins Creed II?", "Ezio Auditore"));
        perguntas.add(new Pergunta("Qual o verdadeiro nome do Batman?", "Bruce Wayne"));
        perguntas.add(new Pergunta("Em De Volta para o Futuro, qual é o ano para qual Marty McFly viaja pela primeira vez?", "1955"));

        boolean continuar = true;

            System.out.println("===== Bem-vindo ao Jogo de Perguntas =====");

            while(continuar){
                System.out.println("Escolha uma opção: ");
                System.out.println("1 - Iniciar jogo");
                System.out.println("2 - Como jogar");
                System.out.println("3 - Adicionar pergunta");
                System.out.println("4 - Sair");
                int opcao = sc.nextInt();
                sc.nextLine();

                switch(opcao) {
                    case 1:
                        iniciarJogo (sc, perguntas);
                        break;
                    case 2:
                        exibirComoJogar();
                        break;
                    case 3:
                        adicionarPergunta(sc, perguntas);
                        break;
                    case 4:
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

    private static void iniciarJogo (Scanner sc, List<Pergunta> perguntas) {
        int pontos = 0;
        boolean todasPerguntasRespondidas = true;

        for (Pergunta pergunta : perguntas) {
            String resposta = "";
            while(!resposta.equalsIgnoreCase(pergunta.getResposta())){
                System.out.println(pergunta.getPergunta());
                resposta = sc.nextLine();

                if (resposta.equalsIgnoreCase ("pular")){
                    System.out.println("Você pulou está pergunta!");
                    todasPerguntasRespondidas = false;
                    break;
                }

                if (!resposta.equalsIgnoreCase(pergunta.getResposta())){
                    System.out.println("Você errou! Tente novamente!");
                } else {
                    System.out.println("Resposta correta. Parabéns!");
                    pontos ++;
                }
            }
        }

        System.out.println("Parabéns, você completou o jogo!");
        System.out.println("Sua pontuação final é: " + pontos);

        if (todasPerguntasRespondidas){
            System.out.println("Você completou o jogo. Até a próxima.");
        }
    }

    private static void exibirComoJogar() {
        System.out.println("Como jogar:");
        System.out.println("1. Você será apresentado a uma série de perguntas.");
        System.out.println("2. Digite a resposta correta para cada pergunta.");
        System.out.println("3. Se você quiser pular uma pergunta, digite 'pular'.");
        System.out.println("4. O jogo continuará até que todas as perguntas sejam respondidas.");
    }


    private static void adicionarPergunta(Scanner sc, List<Pergunta> perguntas) {
        System.out.println("Digite a nova pergunta:");
        String novaPergunta = sc.nextLine().trim();
        System.out.println("Digite a resposta da nova pergunta:");
        String novaResposta = sc.nextLine().trim();
        perguntas.add(new Pergunta(novaPergunta, novaResposta));
        System.out.println("Nova pergunta adicionada com sucesso!");
    }
}


        

