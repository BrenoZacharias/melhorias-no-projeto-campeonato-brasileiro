package br.com.cbf.campeonatobrasileiro.exception;

public class GerarJogoQuantidadeTimeImparException extends RuntimeException{
    public GerarJogoQuantidadeTimeImparException() {
        super("Não é possível gerar jogos com uma quantidade impar de times, pois assim um time não participará das rodadas");
    }
}
