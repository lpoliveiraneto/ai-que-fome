package br.com.aiquefome.aiquefome.domain.exceptions;

public class CidadeNotFoundException extends RuntimeException{
    
    public CidadeNotFoundException(String exception){
        super(exception);
    }
}
