package br.com.fiap.ChallengeIdWall.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "T_MANDADO_PRISAO")
public class MandadoPrisao {
    @Id
    @Column(name = "id_mandado")
    @SequenceGenerator(name = "mandado", sequenceName = "SQ_MANDADO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mandado")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_procurado")
    @JsonBackReference(value="mandados_prisao")
    private Procurado procurado;

    @Column(name = "acusacao")
    private String acusacao;

    @Column(name = "traducao_acusacao")
    private String traducao_acusacao;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    @JsonBackReference(value="pais")
    private Pais pais;

    public MandadoPrisao() {}

    public MandadoPrisao(int id, String acusacao, String traducao_acusacao, Procurado procurado, Pais pais) {
        this.id = id;
        this.acusacao = acusacao;
        this.traducao_acusacao = traducao_acusacao;
        this.procurado = procurado;
        this.pais = pais;
    }

    @JsonBackReference
    public Procurado getProcurado() {
        return procurado;
    }

    public void setProcurado(Procurado procurado) {
        this.procurado = procurado;
    }


    public Integer getId() {
        return id;
    }

    public MandadoPrisao setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAcusacao() {
        return acusacao;
    }

    public void setAcusacao(String tipo) {
        this.acusacao = tipo;
    }

    public String getTraducao_acusacao() {
        return traducao_acusacao;
    }

    public void setTraducao_acusacao(String descricao) {
        this.traducao_acusacao = descricao;
    }

    @JsonBackReference
    public Pais getPais() {
        return pais;
    }

    public MandadoPrisao setPais(Pais pais) {
        this.pais = pais;
        return this;
    }
}
