package br.com.fiap.ChallengeIdWall.Model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_country")
public class Pais {

    @Id
    @Column(name = "country_id")
    @SequenceGenerator(name = "country", sequenceName = "sq_country", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country")
    private int id;

    @Column(name = "country_name")
    private String name;

    public Pais() { }
}
