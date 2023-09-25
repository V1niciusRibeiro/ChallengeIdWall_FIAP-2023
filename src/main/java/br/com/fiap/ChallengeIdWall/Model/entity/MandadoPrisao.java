package br.com.fiap.ChallengeIdWall.Model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_warrant")
public class MandadoPrisao {
    @Id
    @Column(name = "warrant_id")
    @SequenceGenerator(name = "warrant", sequenceName = "sq_warrant", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "warrant")
    private int id;

    @ManyToOne
    @JoinColumn(name = "wanted_id")
    @JsonBackReference(value ="wanted")
    private Procurado wantedId;

    @Column(name = "acusation")
    private String acusation;

    @Column(name = "acusation_translate")
    private String acusationTranslate;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonBackReference(value="country")
    private Pais countryId;

    public MandadoPrisao() {}
}
