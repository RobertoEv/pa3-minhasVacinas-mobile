package com.betoe.minhasvacinas.model;

/**
 * Created by roberto on 12/13/17.
 */

public class Vacina {

    private String nome;
    private String dataAplicacao;
    private String dataRetorno;
    private String aplicador;

    public Vacina(String nome, String dataAplicacao, String dataRetorno, String aplicador) {
        this.nome = nome;
        this.dataAplicacao = dataAplicacao;
        this.dataRetorno = dataRetorno;
        this.aplicador = aplicador;
    }

    @Override
    public String toString() {
        return  "Vacina: " + nome + '\n' +
                "Data: " + dataAplicacao + '\n' +
                "Reforço: " + dataRetorno + '\n' +
                "Veterinário: " + aplicador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(String dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public String getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(String dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public String getAplicador() {
        return aplicador;
    }

    public void setAplicador(String aplicador) {
        this.aplicador = aplicador;
    }
}
