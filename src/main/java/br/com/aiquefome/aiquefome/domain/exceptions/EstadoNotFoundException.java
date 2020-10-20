package br.com.aiquefome.aiquefome.domain.exceptions;


public class EstadoNotFoundException extends RuntimeException{
    
    public EstadoNotFoundException(String exception){
        super(exception);
    }
}
