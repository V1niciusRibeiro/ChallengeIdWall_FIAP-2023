package br.com.fiap.ChallengeIdWall.API_RestFull.Model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_nickName")
public class NickName {

    @Id
    @Column(name = "nickName_id")
    @SequenceGenerator(name = "nickName", sequenceName = "sq_nickName", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nickName")
    private int id;

    @ManyToOne
    @JoinColumn(name = "wanted_id")
    @JsonBackReference(value ="wanted")
    private Wanted wantedId;

    @Column(name = "nickName")
    private String name;

    public NickName(int id, Wanted wantedId, String name) {
        this.id = id;
        this.wantedId = wantedId;
        this.name = name;
    }
}
