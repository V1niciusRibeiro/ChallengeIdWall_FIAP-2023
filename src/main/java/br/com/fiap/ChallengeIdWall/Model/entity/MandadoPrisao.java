package br.com.fiap.ChallengeIdWall.Model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "T_MANDADO_PRISAO")
public class MandadoPrisao {
    @Id
    @Column(name = "id_mandado")
    @SequenceGenerator(name = "mandado", sequenceName = "SQ_MANDADO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mandado")
    private int id;

    @ManyToOne
    @JoinColumn(name = "wanted_id")
    @JsonBackReference(value ="wanted")
    private Procurado wantedId;

    @Column(name = "acusacao")
    private String acusacao;

    @Column(name = "traducao_acusacao")
    private String traducao_acusacao;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonBackReference(value="country")
    private Pais countryId;

    public MandadoPrisao() {}
}
