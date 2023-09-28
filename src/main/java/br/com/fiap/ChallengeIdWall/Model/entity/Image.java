package br.com.fiap.ChallengeIdWall.Model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_image")
public class Image {

    @Id
    @Column(name = "image_id")
    @SequenceGenerator(name = "image", sequenceName = "sq_image", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image")
    private int id;

    @ManyToOne
    @JoinColumn(name = "wanted_id")
    @JsonBackReference(value ="wanted")
    private Wanted wantedId;

    @Column(name = "original_image")
    private String original;

    @Column(name="big_image")
    private String big;

    @Column(name = "small_image")
    private String small;

    public Image(int id, Wanted wantedId, String original, String big, String small) {
        this.id = id;
        this.wantedId = wantedId;
        this.original = original;
        this.big = big;
        this.small = small;
    }

    public Image() { }
}
