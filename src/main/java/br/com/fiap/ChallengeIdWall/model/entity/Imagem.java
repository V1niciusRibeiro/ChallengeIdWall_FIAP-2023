package br.com.fiap.ChallengeIdwall.Model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "T_Imagem")
public class Imagem {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "imagem", sequenceName = "sq_imagem", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imagem")
    private int id;

    @ManyToOne
    @JoinColumn(name = "procurado_id")
    private Procurado procurado;

    @Column(name = "imagem_original")
    private String original;

    @Column(name="imagem_grande")
    private String grande;

    @Column(name = "imagem_miniatura")
    private String miniatura;

    public Imagem() { }
    public Imagem(int id, Procurado procurado, String original, String grande, String miniatura) {
        this.id = id;
        this.procurado = procurado;
        this.original = original;
        this.grande = grande;
        this.miniatura = miniatura;
    }

    @Override
    public String toString() {
        return "Imagem{" +
                "id=" + id +
                ", procurado=" + procurado +
                ", original='" + original + '\'' +
                ", grande='" + grande + '\'' +
                ", miniature='" + miniatura + '\'' +
                '}';
    }
}
