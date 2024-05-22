package com.academify.model.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "banda")
public class Banda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Boolean atividadeBanda;
    private int quantidadeMusicas;

    @DateTimeFormat(pattern = "AAAA")
    private Date dataCriacao;

    @DateTimeFormat(pattern = "AAAA")
    private Date dataDissolucao;
    private String paisOrigem;
    private String registroBanda;
    private int quantidadeIntegrantes;
    private String singleDestaque;
    private String albumDestaque;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estiloMusical_id", nullable = false)
    private EstiloMusical estiloMusical;

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

    public Boolean getAtividadeBanda() {
        return atividadeBanda;
    }

    public void setAtividadeBanda(Boolean atividadeBanda) {
        this.atividadeBanda = atividadeBanda;
    }

    public int getQuantidadeMusicas() {
        return quantidadeMusicas;
    }

    public void setQuantidadeMusicas(int quantidadeMusicas) {
        this.quantidadeMusicas = quantidadeMusicas;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataDissolucao() {
        return dataDissolucao;
    }

    public void setDataDissolucao(Date dataDissolucao) {
        this.dataDissolucao = dataDissolucao;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getRegistroBanda() {
        return registroBanda;
    }

    public void setRegistroBanda(String registroBanda) {
        this.registroBanda = registroBanda;
    }

    public int getQuantidadeIntegrantes() {
        return quantidadeIntegrantes;
    }

    public void setQuantidadeIntegrantes(int quantidadeIntegrantes) {
        this.quantidadeIntegrantes = quantidadeIntegrantes;
    }

    public String getSingleDestaque() {
        return singleDestaque;
    }

    public void setSingleDestaque(String singleDestaque) {
        this.singleDestaque = singleDestaque;
    }

    public String getAlbumDestaque() {
        return albumDestaque;
    }

    public void setAlbumDestaque(String albumDestaque) {
        this.albumDestaque = albumDestaque;
    }

    public EstiloMusical getEstiloMusical() {
        return estiloMusical;
    }

    public void setEstiloMusical(EstiloMusical estiloMusical) {
        this.estiloMusical = estiloMusical;
    }
}
