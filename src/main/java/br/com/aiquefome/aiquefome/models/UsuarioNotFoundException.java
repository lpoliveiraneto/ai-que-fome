package br.com.aiquefome.aiquefome.models;

public class UsuarioNotFoundException extends RuntimeException{

    public UsuarioNotFoundException(String exception){
        super(exception);
    }
    
}
