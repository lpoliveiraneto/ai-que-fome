package br.com.aiquefome.aiquefome.domain.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Restaurante {

    @EqualsAndHashCode.Include
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
}
