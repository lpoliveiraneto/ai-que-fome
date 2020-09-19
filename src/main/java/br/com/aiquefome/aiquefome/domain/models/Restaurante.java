package br.com.aiquefome.aiquefome.domain.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Restaurante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "taxaFrente")
    private BigDecimal taxaFrete;

    @Column(name = "ativo")
    private boolean ativo;

    @Transient
    private boolean aberto;

    @ManyToOne
    @JoinColumn(name = "cozinha_id")
    private Cozinha cozinha;

    public Restaurante(){}

    public Restaurante(String nome, BigDecimal taxaFrete, boolean ativo, boolean aberto, Cozinha cozinha){
        this.nome = nome;
        this.taxaFrete = taxaFrete;
        this.ativo = ativo;
        this.aberto = aberto;
        this.cozinha = cozinha;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public BigDecimal getTaxaFrete(){
        return taxaFrete;
    }

    public void setTaxaFrete(BigDecimal taxaFrete){
        this.taxaFrete = taxaFrete;
    }

    public boolean getAtivo(){
        return ativo;
    }

    public void setAtivo(boolean ativo){
        this.ativo = ativo;
    }

    public boolean getAberto(){
        return aberto;
    }

    public void setAberto(boolean aberto){
        this.aberto = aberto;
    }

    public Cozinha getCozinha(){
        return cozinha;
    }

    public void setCozinha(Cozinha cozinha){
        this.cozinha = cozinha;
    }


}
