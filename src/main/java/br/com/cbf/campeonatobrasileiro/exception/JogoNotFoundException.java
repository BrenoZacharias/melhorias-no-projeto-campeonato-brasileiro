package br.com.cbf.campeonatobrasileiro.exception;

public class JogoNotFoundException extends RuntimeException {
    public JogoNotFoundException(Integer id) {
        super("Jogo com id " + id + " não encontrado");
    }
}
