package br.com.aiquefome.aiquefome.domain.exceptions;

public class UsuarioNotFoundException extends RuntimeException{

    public UsuarioNotFoundException(String exception){
        super(exception);
    }
    
}
