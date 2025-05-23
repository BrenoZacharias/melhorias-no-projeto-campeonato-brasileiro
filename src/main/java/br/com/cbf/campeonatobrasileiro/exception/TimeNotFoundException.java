package br.com.cbf.campeonatobrasileiro.exception;

public class TimeNotFoundException extends RuntimeException{
    public TimeNotFoundException(Integer id) {
        super("Time com id " + id + " não encontrado");
    }
}
