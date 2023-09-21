package br.com.fiap.ChallengeIdwall.Model.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "T_Imagem")
public class Imagem {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "", sequenceName = "", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "")
    private String id;

    private String idProcurado;

    private String original;

    private String grande;

    private String miniature;
}
