package br.com.fiap.ChallengeIdwall.Model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "T_IDIOMA")
public class Idioma {

    @Id
    @Column(name = "id_idioma")
    @SequenceGenerator(name = "idioma", sequenceName = "SQ_IDIOMA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idioma")
    private int id;

    @Column(name = "nm_idioma")
    private String nome;

    public int getId() {
        return id;
    }

    public Idioma setId(int id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Idioma setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Idioma() {
    }

    public Idioma(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
