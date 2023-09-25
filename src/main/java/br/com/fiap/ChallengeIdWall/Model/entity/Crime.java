package br.com.fiap.ChallengeIdWall.Model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "T_CRIME")
public class Crime {
    @Id
    @Column(name = "id_crime")
    @SequenceGenerator(name = "crime", sequenceName = "SQ_CRIME", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crime")
    private int id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "wanted_id")
    @JsonBackReference(value ="wanted")
    private Procurado wantedId;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    @JsonBackReference(value="pais")
    private Pais pais;

    public Crime() {}
}
