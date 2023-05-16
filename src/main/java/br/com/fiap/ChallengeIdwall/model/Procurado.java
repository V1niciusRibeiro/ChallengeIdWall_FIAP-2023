package br.com.fiap.ChallengeIdwall.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "T_PROCURADO")
public class Procurado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nasc_local")
    private String nasclocal;

    @Column(name = "altura")
    private Double altura;

    @Column(name = "cor_Olhos")
    private String corOlhos;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "cor_Cabelo")
    private String corCabelo;

    @Column(name = "ocupacao")
    private String ocupacao;

    @Column(name = "idiomas")
    private String idiomas;

    @Column(name = "nacionalidade")
    private String nacionalidade;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "perigo")
    private Boolean perigo;

    @Column(name = "recompensa")
    private Double recompensa;

    @Column(name = "raca")
    private String raca;

    @OneToMany(mappedBy = "procurado")
    private List<Crime> crime;

    @OneToMany(mappedBy = "procurado")
    private List<Registro> registro;

    public List<Registro> getRegistro() {
        return registro;
    }

    public void setRegistro(List<Registro> registro) {
        this.registro = registro;
    }

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

    public String getNascLocal() {
        return nasclocal;
    }

    public void setNasclocal(String nasclocal) {
        this.nasclocal = nasclocal;
    }


    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getCorOlhos() {
        return corOlhos;
    }

    public void setCorOlhos(String corOlhos) {
        this.corOlhos = corOlhos;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
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

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
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

    public Double getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Double recompensa) {
        this.recompensa = recompensa;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Procurado(int id, String nasclocal, Double altura, String corOlhos, Double peso, String corCabelo, String ocupacao, String idiomas, String nacionalidade, String descricao, Boolean perigo, Double recompensa, String raca, List<Crime> crime, List<Registro> registro) {
        super();
        this.id = id;
        this.nasclocal = nasclocal;
        this.altura = altura;
        this.corOlhos = corOlhos;
        this.peso = peso;
        this.corCabelo = corCabelo;
        this.ocupacao = ocupacao;
        this.idiomas = idiomas;
        this.nacionalidade = nacionalidade;
        this.descricao = descricao;
        this.perigo = perigo;
        this.recompensa = recompensa;
        this.raca = raca;
        this.crime = crime;
        this.registro = registro;
    }

    public Procurado() {}




}
