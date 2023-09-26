package br.com.fiap.ChallengeIdWall.Model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_crime")
public class Crime {
    @Id
    @Column(name = "crime_id")
    @SequenceGenerator(name = "crime", sequenceName = "sq_crime", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crime")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "wanted_id")
    @JsonBackReference(value ="wanted")
    private Wanted wantedId;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonBackReference(value="country")
    private Country countryId;

    public Crime() {}
}
