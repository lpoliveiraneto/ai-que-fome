package br.com.aiquefome.aiquefome.api.handler;

import java.time.LocalDateTime;

public class Problema {

    private LocalDateTime data;
    private String mensagem;
    private String exception;

    public Problema(LocalDateTime data, String mensagem, String exception) {
        this.data = data;
        this.mensagem = mensagem;
        this.exception = exception;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getException() {
        return exception;
    }
}
