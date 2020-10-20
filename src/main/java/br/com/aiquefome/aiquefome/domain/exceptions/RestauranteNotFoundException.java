package br.com.aiquefome.aiquefome.domain.exceptions;

public class RestauranteNotFoundException extends RuntimeException {
    
    public RestauranteNotFoundException(String exception){
        super(exception);
    }
}
