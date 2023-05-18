package br.com.fiap.ChallengeIdWall.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_PAIS")
public class Pais {

    @Id
    @Column(name = "id_pais")
    @SequenceGenerator(name = "pais", sequenceName = "SQ_PAIS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pais")
    private int id;

    @Column(name = "nm_pais")
    private String nome;

    public int getId() {
        return id;
    }

    public Pais setId(int id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Pais setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Pais() {
    }

    public Pais(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
