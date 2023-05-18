package br.com.fiap.ChallengeIdWall.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "T_APELIDO")
public class Apelido {

    @Id
    @Column(name = "id_apelido")
    @SequenceGenerator(name = "apelido", sequenceName = "SQ_APELIDO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apelido")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_procurado")
    @JsonBackReference(value="procurado")
    private Procurado procurado;

    @Column(name = "nm_apelido")
    private String nome;

    public int getId() {
        return id;
    }

    public Apelido setId(int id) {
        this.id = id;
        return this;
    }

    @JsonBackReference
    public Procurado getProcurado() {
        return procurado;
    }

    public Apelido setProcurado(Procurado procurado) {
        this.procurado = procurado;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Apelido setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Apelido() {
    }

    public Apelido(int id, Procurado procurado, String nome) {
        this.id = id;
        this.procurado = procurado;
        this.nome = nome;
    }

}
