package JogoDePerguntas;

public class Pergunta {
    private String pergunta;
    private String resposta;

    public Pergunta(String pergunta, String resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String getResposta(){
        return resposta;
    }
}
