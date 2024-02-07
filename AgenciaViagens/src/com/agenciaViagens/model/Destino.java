package com.agenciaViagens.model;

public class Destino {

    private int idDestino;
    private String nomeDestino;
    private String estadoDestino;
    private String paisDestino;
    private String dataDestino;
    private String precoDestino;

    public Destino(int idDestino, String nomeDestino, String estadoDestino, String paisDestino, String dataDestino, String precoDestino) {
        this.idDestino = idDestino;
        this.nomeDestino = nomeDestino;
        this.estadoDestino = estadoDestino;
        this.paisDestino = paisDestino;
        this.dataDestino = dataDestino;
        this.precoDestino = precoDestino;
    }

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public String getNomeDestino() {
        return nomeDestino;
    }

    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
    }

    public String getEstadoDestino() {
        return estadoDestino;
    }

    public void setEstadoDestino(String estadoDestino) {
        this.estadoDestino = estadoDestino;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public String getDataDestino() {
        return dataDestino;
    }

    public void setDataDestino(String dataDestino) {
        this.dataDestino = dataDestino;
    }

    public String getPrecoDestino() {
        return precoDestino;
    }

    public void setPrecoDestino(String precoDestino) {
        this.precoDestino = precoDestino;
    }
}
