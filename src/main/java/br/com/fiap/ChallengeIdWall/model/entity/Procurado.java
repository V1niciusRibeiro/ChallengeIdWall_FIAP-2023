package br.com.fiap.ChallengeIdwall.Model.entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;

@Getter
@Entity
@Table(name = "T_PROCURADO")
public class Procurado {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "procurado", sequenceName = "SQ_PROCURADO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "procurado")
    private int id;

    @Column(name = "procurado_raca")
    private String raca;

    @Column(name = "peso")
    private  String peso;

    @Column(name = "procurado_olho")
    private String Olho;
    @Column(name = "procurado_altura")
    private  String altura;
    @Column(name = "procurado_cabelo")
    private String cabelo;

    @Column(name = "procurado_sexo")
    private String sexo;

    @Column(name = "procurado_img")
    private List<Imagem> imagem;

    @Column(name = "procurado_LocalNasc")
    private String localNascimento;
    @Column(name = "procurado_obs")
    private String observacao;

    @Column(name = "procurado_descricao")
    private String descricao;

    @Column(name = "procurado_cautela")
    private String cautela;

    @OneToMany(mappedBy = "procurado")
    @JsonManagedReference(value="procurado_idioma")
    private List<IdiomaFalado> idioma_falado;

    @OneToMany(mappedBy = "procurado")
    @JsonManagedReference(value="procurado_prisao")
    private List<Crime> mandado_prisao;

    public Procurado() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public void setOlho(String olho) {
        Olho = olho;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public void setCabelo(String cabelo) {
        this.cabelo = cabelo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setImagem(List<Imagem> imagem) {
        this.imagem = imagem;
    }

    public void setLocalNascimento(String localNascimento) {
        this.localNascimento = localNascimento;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCautela(String cautela) {
        this.cautela = cautela;
    }

    public void setIdioma_falado(List<IdiomaFalado> idioma_falado) {
        this.idioma_falado = idioma_falado;
    }

    public void setMandado_prisao(List<Crime> mandado_prisao) {
        this.mandado_prisao = mandado_prisao;
    }

    public void setIdentidade(List<Identidade> identidade) {
        this.identidade = identidade;
    }

    public void setNacionalidade(List<Nacionalidade> nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setApelido(List<Apelido> apelido) {
        this.apelido = apelido;
    }

    @OneToMany(mappedBy = "procurado")
    @JsonManagedReference(value="procurado_identidade")
    private List<Identidade> identidade;

    @OneToMany(mappedBy = "procurado")
    @JsonManagedReference(value="procurado_nacionalidade")
    private List<Nacionalidade> nacionalidade;

    @OneToMany(mappedBy = "procurado")
    @JsonManagedReference(value="procurado_apelido")
    private List<Apelido> apelido;

    @Override
    public String toString() {
        return "Procurado{" +
                "id=" + id +
                ", raca='" + raca + '\'' +
                ", peso='" + peso + '\'' +
                ", Olho='" + Olho + '\'' +
                ", altura='" + altura + '\'' +
                ", cabelo='" + cabelo + '\'' +
                ", sexo='" + sexo + '\'' +
                ", imagem=" + imagem +
                ", localNascimento='" + localNascimento + '\'' +
                ", observacao='" + observacao + '\'' +
                ", descricao='" + descricao + '\'' +
                ", cautela='" + cautela + '\'' +
                ", idioma_falado=" + idioma_falado +
                ", mandado_prisao=" + mandado_prisao +
                ", identidade=" + identidade +
                ", nacionalidade=" + nacionalidade +
                ", apelido=" + apelido +
                '}';
    }

}