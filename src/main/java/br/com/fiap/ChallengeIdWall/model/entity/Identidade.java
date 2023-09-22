package br.com.fiap.ChallengeIdwall.Model.entity;

import jakarta.persistence.*;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@Entity
@Table(name = "T_IDENTIDADE")
public class Identidade {

    @Id
    @Column(name = "id_identidade")
    @SequenceGenerator(name = "identidade", sequenceName = "SQ_IDENTIDADE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "identidade")
    private int id;

    @Column(name = "id_nome")
    private String nome;

    @Column(name = "id_sobrenome")
    private String sobrenome;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "id_dtnasc")
    private Date dataNascimento;

    @Column(name = "id_sexo")
    private String sexo;

    public Identidade() {
    }

    public Identidade(int id, String nome, String sobrenome, Date dataNascimento, String sexo) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Identidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
