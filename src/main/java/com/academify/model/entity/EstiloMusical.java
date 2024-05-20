package com.academify.model.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "estilo-musical")
public class EstiloMusical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(length = 200)
    private String descricao;
    private String figuraImportante;
    private String instrumentoPrincipal;
    private String paisOrigem;
    private String paisMaiorPopularidade;

    @DateTimeFormat(pattern = "AAAA")
    private Date anoSurgimento;

    @OneToMany(mappedBy = "estiloMusical")
    private List<Banda> banda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFiguraImportante() {
        return figuraImportante;
    }

    public void setFiguraImportante(String figuraImportante) {
        this.figuraImportante = figuraImportante;
    }

    public String getInstrumentoPrincipal() {
        return instrumentoPrincipal;
    }

    public void setInstrumentoPrincipal(String instrumentoPrincipal) {
        this.instrumentoPrincipal = instrumentoPrincipal;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getPaisMaiorPopularidade() {
        return paisMaiorPopularidade;
    }

    public void setPaisMaiorPopularidade(String paisMaiorPopularidade) {
        this.paisMaiorPopularidade = paisMaiorPopularidade;
    }

    public Date getAnoSurgimento() {
        return anoSurgimento;
    }

    public void setAnoSurgimento(Date anoSurgimento) {
        this.anoSurgimento = anoSurgimento;
    }

    public List<Banda> getBanda() {
        return banda;
    }

    public void setBanda(List<Banda> banda) {
        this.banda = banda;
    }
}
