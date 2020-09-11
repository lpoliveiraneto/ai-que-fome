package br.com.aiquefome.aiquefome.models;

public class CozinhaNotFoundException extends RuntimeException{

    public CozinhaNotFoundException(String exception){
        super(exception);
    }
}
