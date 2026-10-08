package com.charlly.sistema_entregas.exception;

public class LoginJaCadastradoException extends RuntimeException{
    public LoginJaCadastradoException(String login) {
        super("Login já está sendo usado: " + login);
    }
}
