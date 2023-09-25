package br.com.fiap.ChallengeIdWall.Model.entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "T_WANTED")
public class Procurado {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "wanted", sequenceName = "sq_wanted", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wanted")
    private int id;

    @Column(name = "race_wanted")
    private String race;

    @Column(name = "weight_wanted")
    private  String weight;

    @Column(name = "eye_wanted")
    private String eye;

    @Column(name = "height_wanted")
    private  String height;

    @Column(name = "hair_wanted")
    private String hair;

    @Column(name = "sex_wanted")
    private String sex;

    @Column(name = "birth_place_wanted")
    private String birthPlace;

    @Column(name = "observation_wanted")
    private String observation;

    @Column(name = "description_wanted")
    private String description;

    @Column(name = "careful_wanted")
    private String careful;

    @OneToMany(mappedBy = "wantedId")
    private List<Imagem> imageId;

    @OneToMany(mappedBy = "wantedId")
    private List<IdiomaFalado> languageId;

    @OneToMany(mappedBy = "wantedId")
    private List<MandadoPrisao> warrantId;

    @OneToMany(mappedBy = "wantedId")
    private List<Crime> crimeId;

    @OneToMany(mappedBy = "wantedId")
    private List<Identidade> identityId;

    @OneToMany(mappedBy = "wantedId")
    private List<Nacionalidade> nationalityId;

    @OneToMany(mappedBy = "wantedId")
    private List<Apelido> nickNameId;
    public Procurado() { }
}