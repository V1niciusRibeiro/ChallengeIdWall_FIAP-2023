package br.com.fiap.ChallengeIdwall.Model.entity;

import br.com.fiap.ChallengeIdwall.Model.entity.IdiomaFalado;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "T_IDIOMA")
public class Idioma {

    @Id
    @Column(name = "id_idioma")
    @SequenceGenerator(name = "idioma", sequenceName = "SQ_IDIOMA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idioma")
    private int id;

    @Column(name = "nm_idioma")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idioma_falado_id")
    private IdiomaFalado idiomaFalado;

    public Idioma() {
    }

    public Idioma(int id, String nome, IdiomaFalado idiomaFalado) {
        this.id = id;
        this.nome = nome;
        this.idiomaFalado = idiomaFalado;
    }

    @Override
    public String toString() {
        return "Idioma{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idiomaFalado=" + idiomaFalado +
                '}';
    }
}