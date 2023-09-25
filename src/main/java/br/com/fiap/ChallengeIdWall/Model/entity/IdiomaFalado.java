package br.com.fiap.ChallengeIdWall.Model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_spokenLanguage")
public class IdiomaFalado {

    @Id
    @Column(name = "spokenLanguage_id")
    @SequenceGenerator(name = "spokenLanguage", sequenceName = "sq_spokenLanguage", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spokenLanguage")
    private int id;

    @ManyToOne
    @JoinColumn(name = "language_id")
    @JsonBackReference(value = "language")
    private Idioma language;

    @ManyToOne
    @JoinColumn(name = "wanted_id")
    @JsonBackReference(value ="wanted")
    private Procurado wantedId;
    public IdiomaFalado() {
    }
}
