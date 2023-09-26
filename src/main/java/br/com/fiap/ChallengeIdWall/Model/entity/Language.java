package br.com.fiap.ChallengeIdWall.Model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_spokenLanguage")
public class Language {

    @Id
    @Column(name = "language_id")
    @SequenceGenerator(name = "language", sequenceName = "sq_language", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "language")
    private int id;

    @Column(name = "nm_language")
    private String name;

    @ManyToOne
    @JoinColumn(name = "spokenLanguage_id")
    private SpokenLanguage spokenLanguageId;

    public Language() {
    }
}