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

    @Column(name = "lastName_id")
    private String lastName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birthDate_id")
    private Date birthDate;

    @Column(name = "sex_id")
    private String sex;

    @ManyToOne
    @JoinColumn(name = "wanted_id")
    @JsonBackReference(value ="wanted")
    private Wanted wantedId;

    public Identity() {
    }

    public Identity(int id, String name, String lastName, Date birthDate, String sex) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Identidade{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", sex='" + sex + '\'' +
                '}';
    }
}
