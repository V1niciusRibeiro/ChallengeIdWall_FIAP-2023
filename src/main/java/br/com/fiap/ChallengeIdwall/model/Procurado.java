package br.com.fiap.ChallengeIdWall.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "T_PROCURADO")
public class Procurado {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "procurado", sequenceName = "SQ_PROCURADO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "procurado")
    private int id;

    @Column(name = "nasc_local")
    private String localNascimento;

    @Column(name = "altura")
    private  String altura;

    @Column(name = "cor_Olhos")
    private String corOlhos;

    @Column(name = "peso")
    private  String peso;

    @Column(name = "cor_Cabelo")
    private String corCabelo;

    @Column(name = "ocupacao")
    private String ocupacao;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "perigo")
    private Boolean perigo;

    @Column(name = "recompensa")
    private  String recompensa;

    @Column(name = "raca")
    private String raca;

    @OneToMany(mappedBy = "procurado")
    @JsonManagedReference(value="idiomas")
    private List<IdiomaFalado> idiomas;

    @OneToMany(mappedBy = "procurado")
    @JsonManagedReference(value="crimes")
    private List<Crime> crime;

    @OneToMany(mappedBy = "procurado")
    @JsonManagedReference(value="identidade")
    private List<Identidade> identidade;

    @OneToMany(mappedBy = "procurado")
    @JsonManagedReference(value="nacionalidade")
    private List<Nacionalidade> nacionalidade;

    @OneToMany(mappedBy = "procurado")
    @JsonManagedReference(value="apelidos")
    private List<Apelido> apelidos;

    @JsonManagedReference
    public List<Identidade> getRegistro() {
        return identidade;
    }

    public void setRegistro(List<Identidade> identidade) {
        this.identidade = identidade;
    }

    @JsonManagedReference
    public List<Crime> getCrime() {
        return crime;
    }

    public void setCrime(List<Crime> crime) {
        this.crime = crime;
    }


    public Integer getId() {
        return id;
    }

    public Procurado setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getlocalNascimento() {
        return localNascimento;
    }

    public void setlocalNascimento(String localNascimento) {
        this.localNascimento = localNascimento;
    }


    public  String getAltura() {
        return altura;
    }

    public void setAltura( String altura) {
        this.altura = altura;
    }

    public String getCorOlhos() {
        return corOlhos;
    }

    public void setCorOlhos(String corOlhos) {
        this.corOlhos = corOlhos;
    }

    public  String getPeso() {
        return peso;
    }

    public void setPeso( String peso) {
        this.peso = peso;
    }

    public String getCorCabelo() {
        return corCabelo;
    }

    public void setCorCabelo(String corCabelo) {
        this.corCabelo = corCabelo;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    @JsonManagedReference
    public List<IdiomaFalado> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<IdiomaFalado> idiomas) {
        this.idiomas = idiomas;
    }

    @JsonManagedReference
    public List<Nacionalidade> getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(List<Nacionalidade> nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Boolean getPerigo() {
        return perigo;
    }

    public void setPerigo(Boolean perigo) {
        this.perigo = perigo;
    }

    public  String getRecompensa() {
        return recompensa;
    }

    public void setRecompensa( String recompensa) {
        this.recompensa = recompensa;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    @JsonManagedReference
    public List<Apelido> getApelidos() {
        return apelidos;
    }

    public Procurado setApelidos(List<Apelido> apelidos) {
        this.apelidos = apelidos;
        return this;
    }

    public Procurado() {
    }

    public Procurado(int id, String localNascimento, String altura, String corOlhos, String peso, String corCabelo, String ocupacao, String descricao, Boolean perigo, String recompensa, String raca, List<IdiomaFalado> idiomas, List<Crime> crime, List<Identidade> identidade, List<Nacionalidade> nacionalidade, List<Apelido> apelidos) {
        this.id = id;
        this.localNascimento = localNascimento;
        this.altura = altura;
        this.corOlhos = corOlhos;
        this.peso = peso;
        this.corCabelo = corCabelo;
        this.ocupacao = ocupacao;
        this.descricao = descricao;
        this.perigo = perigo;
        this.recompensa = recompensa;
        this.raca = raca;
        this.idiomas = idiomas;
        this.crime = crime;
        this.identidade = identidade;
        this.nacionalidade = nacionalidade;
        this.apelidos = apelidos;
    }
}