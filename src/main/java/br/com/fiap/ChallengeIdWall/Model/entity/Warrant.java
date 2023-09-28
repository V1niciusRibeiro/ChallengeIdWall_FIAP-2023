package br.com.fiap.ChallengeIdWall.Model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_warrant")
public class Warrant {
    @Id
    @Column(name = "warrant_id")
    @SequenceGenerator(name = "warrant", sequenceName = "sq_warrant", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "warrant")
    private int id;

    @ManyToOne
    @JoinColumn(name = "wanted_id")
    @JsonBackReference(value ="wanted")
    private Wanted wantedId;

    @Column(name = "acusation")
    private String acusation;

    @Column(name = "acusation_translate")
    private String acusationTranslate;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonBackReference(value="country")
    private Country countryId;

    public Warrant(int id, Wanted wantedId, String acusation, String acusationTranslate, Country countryId) {
        this.id = id;
        this.wantedId = wantedId;
        this.acusation = acusation;
        this.acusationTranslate = acusationTranslate;
        this.countryId = countryId;
    }

    public Warrant() {}
}
