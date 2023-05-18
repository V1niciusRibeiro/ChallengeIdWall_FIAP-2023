package br.com.fiap.ChallengeIdWall.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "T_IDIOMA_FALADO")
public class IdiomaFalado {

    @Id
    @Column(name = "id_idioma_falado")
    @SequenceGenerator(name = "idioma_falado", sequenceName = "SQ_IDIOMA_FALADO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idioma_falado")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_idioma")
    @JsonBackReference(value = "idioma")
    private Idioma idioma;

    @ManyToOne
    @JoinColumn(name = "id_procurado")
    @JsonBackReference(value ="procurado")
    private Procurado procurado;

    public int getId() {
        return id;
    }

    public IdiomaFalado setId(int id) {
        this.id = id;
        return this;
    }

    @JsonManagedReference
    public Idioma getIdioma() {
        return idioma;
    }

    public IdiomaFalado setIdioma(Idioma idioma) {
        this.idioma = idioma;
        return this;
    }

    @JsonManagedReference
    public Procurado getProcurado() {
        return procurado;
    }

    public IdiomaFalado setProcurado(Procurado procurado) {
        this.procurado = procurado;
        return this;
    }

    public IdiomaFalado() {
    }

    public IdiomaFalado(int id, Idioma idioma, Procurado procurado) {
        this.id = id;
        this.idioma = idioma;
        this.procurado = procurado;
    }

}
