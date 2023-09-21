package br.com.fiap.ChallengeIdwall.Model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Calendar;
@Entity
@Table(name = "T_IDENTIDADE")
public class Identidade {

    @Id
    @Column(name = "id_identidade")
    @SequenceGenerator(name = "identidade", sequenceName = "SQ_IDENTIDADE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "identidade")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Dt_Nasc")
    private Calendar dtNasc;

    @Column(name = "sexo")
    private String sexo;

    @ManyToOne
    @JoinColumn(name = "id_procurado")
    @JsonBackReference(value="identidade")
    private Procurado procurado;

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

    public Identidade setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Calendar getDtNasc() {
        return dtNasc;
    }


    public void setDtNasc(Calendar dtNasc) {
        this.dtNasc = dtNasc;
    }


    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Identidade(int id, String nome, String sobrenome, Calendar dtNasc, String sexo, Procurado procurado) {
        super();
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dtNasc = dtNasc;
        this.sexo = sexo;
        this.procurado = procurado;
    }

    public Identidade() {}

}