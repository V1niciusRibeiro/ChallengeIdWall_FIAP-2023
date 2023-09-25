package br.com.fiap.ChallengeIdWall.Model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "T_Image")
public class Imagem {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "image", sequenceName = "sq_image", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image")
    private int id;

    @ManyToOne
    @JoinColumn(name = "wanted_id")
    @JsonBackReference(value ="wanted")
    private Procurado wantedId;

    @Column(name = "original_image")
    private String original;

    @Column(name="big_image")
    private String big;

    @Column(name = "small_image")
    private String small;

    public Imagem() { }
}
