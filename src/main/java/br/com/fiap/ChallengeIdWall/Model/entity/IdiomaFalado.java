package br.com.fiap.ChallengeIdWall.Model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
    private Idioma language;

    @ManyToOne
    @JoinColumn(name = "wanted_id")
    @JsonBackReference(value ="wanted")
    private Procurado wantedId;
    public IdiomaFalado() {
    }
}
