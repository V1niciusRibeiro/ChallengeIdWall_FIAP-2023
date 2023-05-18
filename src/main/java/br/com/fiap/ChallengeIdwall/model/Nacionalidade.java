package br.com.fiap.ChallengeIdWall.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "T_NACIONALIDADE")
public class Nacionalidade {

    @Id
    @Column(name = "id_nacionalidade")
    @SequenceGenerator(name = "nacionalidade", sequenceName = "SQ_NACIONALIDADE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nacionalidade")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_procurado")
    @JsonBackReference(value="nacionalidade")
    private Procurado procurado;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    @JsonBackReference(value="pais")
    private Pais pais;

    public int getId() {
        return id;
    }

    public Nacionalidade setId(int id) {
        this.id = id;
        return this;
    }

    @JsonBackReference
    public Procurado getProcurado() {
        return procurado;
    }

    public Nacionalidade setProcurado(Procurado procurado) {
        this.procurado = procurado;
        return this;
    }

    @JsonBackReference
    public Pais getPais() {
        return pais;
    }

    public Nacionalidade setPais(Pais pais) {
        this.pais = pais;
        return this;
    }

    public Nacionalidade() {
    }

    public Nacionalidade(int id, Procurado procurado, Pais pais) {
        this.id = id;
        this.procurado = procurado;
        this.pais = pais;
    }

}
