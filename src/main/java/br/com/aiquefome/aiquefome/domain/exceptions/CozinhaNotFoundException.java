package br.com.aiquefome.aiquefome.domain.exceptions;

public class CozinhaNotFoundException extends RuntimeException{

    public CozinhaNotFoundException(String exception){
        super(exception);
    }
}
