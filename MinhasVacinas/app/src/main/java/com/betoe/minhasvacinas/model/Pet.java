package com.betoe.minhasvacinas.model;

import com.google.gson.annotations.SerializedName;

public class Pet {

    @SerializedName("petname")
    private String petname;
    @SerializedName("especie")
    private String especie;
    @SerializedName("raca")
    private String raca;
    @SerializedName("peso")
    private String peso;
    @SerializedName("idade")
    private String idade;

    public Pet(String petname, String especie, String raca, String peso, String idade) {
        this.petname = petname;
        this.especie = especie;
        this.raca = raca;
        this.peso = peso;
        this.idade = idade;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}