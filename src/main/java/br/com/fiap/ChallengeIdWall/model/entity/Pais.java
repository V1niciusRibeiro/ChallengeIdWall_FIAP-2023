package br.com.fiap.ChallengeIdwall.Model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "T_PAIS")
public class Pais {

    @Id
    @Column(name = "id_pais")
    @SequenceGenerator(name = "pais", sequenceName = "SQ_PAIS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pais")
    private int id;

    @Column(name = "nm_pais")
    private String nome;

    public Pais() { }

    public Pais(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
