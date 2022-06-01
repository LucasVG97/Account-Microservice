package com.letscode.account.exception;

public class UsuarioException extends RuntimeException {
    public UsuarioException() {super("Não há usuarios com este Id");}
}
