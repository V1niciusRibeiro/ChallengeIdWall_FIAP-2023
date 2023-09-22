package br.com.fiap.ChallengeIdwall.Model.entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "T_PROCURADO")
public class Procurado {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "procurado", sequenceName = "sq_procurado", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "procurado")
    private int id;

    @Column(name = "procurado_raca")
    private String raca;

    @Column(name = "peso")
    private  String peso;

    @Column(name = "procurado_olho")
    private String olho;

    @Column(name = "procurado_altura")
    private  String altura;

    @Column(name = "procurado_cabelo")
    private String cabelo;

    @Column(name = "procurado_sexo")
    private String sexo;

    @Column(name = "procurado_LocalNasc")
    private String localNascimento;

    @Column(name = "procurado_obs")
    private String observacao;

    @Column(name = "procurado_descricao")
    private String descricao;

    @Column(name = "procurado_cautela")
    private String cautela;

    @OneToMany(mappedBy = "procurado")
    private List<Imagem> imagem;

    @OneToMany(mappedBy = "procurado")
    private List<IdiomaFalado> idioma;

    @OneToMany(mappedBy = "procurado")
    private List<Crime> mandado;

    @OneToMany(mappedBy = "procurado")
    private List<Identidade> identidade;

    @OneToMany(mappedBy = "procurado")
    private List<Nacionalidade> nacionalidade;

    @OneToMany(mappedBy = "procurado")
    private List<Apelido> apelido;

    public Procurado() { }
    public Procurado(int id, String raca, String peso, String olho, String altura, String cabelo, String sexo,
                     List<Imagem> imagem, String localNascimento, String observacao, String descricao,
                     String cautela, List<IdiomaFalado> idioma, List<Crime> mandado,
                     List<Identidade> identidade, List<Nacionalidade> nacionalidade, List<Apelido> apelido) {
        this.id = id;
        this.raca = raca;
        this.peso = peso;
        this.olho = olho;
        this.altura = altura;
        this.cabelo = cabelo;
        this.sexo = sexo;
        this.imagem = imagem;
        this.localNascimento = localNascimento;
        this.observacao = observacao;
        this.descricao = descricao;
        this.cautela = cautela;
        this.idioma = idioma;
        this.mandado = mandado;
        this.identidade = identidade;
        this.nacionalidade = nacionalidade;
        this.apelido = apelido;
    }

    @Override
    public String toString() {
        return "Procurado{" +
                "id=" + id +
                ", raca='" + raca + '\'' +
                ", peso='" + peso + '\'' +
                ", Olho='" + olho + '\'' +
                ", altura='" + altura + '\'' +
                ", cabelo='" + cabelo + '\'' +
                ", sexo='" + sexo + '\'' +
                ", imagem=" + imagem +
                ", localNascimento='" + localNascimento + '\'' +
                ", observacao='" + observacao + '\'' +
                ", descricao='" + descricao + '\'' +
                ", cautela='" + cautela + '\'' +
                ", idioma=" + idioma +
                ", mandado=" + mandado +
                ", identidade=" + identidade +
                ", nacionalidade=" + nacionalidade +
                ", apelido=" + apelido +
                '}';
    }

}