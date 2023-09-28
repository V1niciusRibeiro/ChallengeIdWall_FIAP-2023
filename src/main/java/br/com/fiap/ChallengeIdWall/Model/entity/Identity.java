package br.com.fiap.ChallengeIdWall.Model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@Entity
@Table(name = "t_identity")
public class Identity {

    @Id
    @Column(name = "identity_id")
    @SequenceGenerator(name = "identity", sequenceName = "sq_identity", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "identity")
    private int id;

    @Column(name = "name_id")
    private String name;

    @Column(name = "foreName_id")
    private String foreName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birthDate_id")
    private String birthDate;

    @Column(name = "sex_id")
    private String sex;

    @ManyToOne
    @JoinColumn(name = "wanted_id")
    @JsonBackReference(value ="wanted")
    private Wanted wantedId;

    public Identity() {
    }

    public Identity(int id, String name, String foreName, String birthDate, String sex, Wanted wanted) {
        this.id = id;
        this.name = name;
        this.foreName = foreName;
        this.birthDate = birthDate;
        this.sex = sex;
        this.wantedId = wanted;
    }

    @Override
    public String toString() {
        return "Identidade{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + foreName + '\'' +
                ", birthDate=" + birthDate +
                ", sex='" + sex + '\'' +
                '}';
    }
}
