package br.com.cbf.campeonatobrasileiro.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 20)
    private String nome;
    @Column(length = 4)
    private String sigla;
    @Column(length = 2)
    private String uf;
    private String estadio;
}
