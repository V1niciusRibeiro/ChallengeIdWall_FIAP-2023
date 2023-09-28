package br.com.fiap.ChallengeIdWall.Model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "t_language")
public class Language {

    @Id
    @Column(name = "language_id")
    @SequenceGenerator(name = "language", sequenceName = "sq_language", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "language")
    private int id;

    @Column(name = "nm_language", unique = true)
    private String name;

    @OneToMany(mappedBy = "language_id")
    private List<SpokenLanguage> spokenLanguageId;

    public Language(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Language() {
    }

}