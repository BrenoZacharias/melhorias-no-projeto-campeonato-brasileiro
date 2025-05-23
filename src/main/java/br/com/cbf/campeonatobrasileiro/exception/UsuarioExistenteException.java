package br.com.cbf.campeonatobrasileiro.exception;

public class UsuarioExistenteException extends RuntimeException{
    public UsuarioExistenteException(String username) {
        super("Usuario com username " + username + " já existe");
    }
}
