package br.com.fiap.ChallengeIdWall.Model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_spokenLanguage")
public class Idioma {

    @Id
    @Column(name = "id_language")
    @SequenceGenerator(name = "language", sequenceName = "SQ_language", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "language")
    private int id;

    @Column(name = "nm_language")
    private String name;

    @ManyToOne
    @JoinColumn(name = "spokenLanguage_id")
    private IdiomaFalado spokenLanguageId;

    public Idioma() {
    }

    public Idioma(int id, String name, IdiomaFalado spokenLanguageId) {
        this.id = id;
        this.name = name;
        this.spokenLanguageId = spokenLanguageId;
    }

    @Override
    public String toString() {
        return "Idioma{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", spokenLanguageId=" + spokenLanguageId +
                '}';
    }
}