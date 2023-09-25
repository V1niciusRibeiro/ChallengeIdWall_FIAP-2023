package br.com.fiap.ChallengeIdWall.Model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import br.com.fiap.ChallengeIdWall.Model.entity.Procurado;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@Entity
@Table(name = "T_IDENTITY")
public class Identidade {

    @Id
    @Column(name = "identity_id")
    @SequenceGenerator(name = "identity", sequenceName = "sq_identity", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "identity")
    private int id;

    @Column(name = "id_name")
    private String name;

    @Column(name = "id_lastName")
    private String lastName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "id_birthDate")
    private Date birthDate;

    @Column(name = "id_sex")
    private String sex;

    @ManyToOne
    @JoinColumn(name = "wanted_id")
    @JsonBackReference(value ="wanted")
    private Procurado wantedId;

    public Identidade() {
    }

    public Identidade(int id, String name, String lastName, Date birthDate, String sex) {
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
