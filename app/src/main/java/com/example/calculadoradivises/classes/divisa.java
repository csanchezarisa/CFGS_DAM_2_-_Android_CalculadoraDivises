package com.example.calculadoradivises.classes;

public class divisa {

    private String nomDivisa;
    private float valorDivisa;
    private boolean divisaInicialitzada;

    public divisa(String nomDivisa) {

        this.nomDivisa = nomDivisa;
        this.valorDivisa = 0;
        this.divisaInicialitzada = false;

    }

    public String getNomDivisa() {
        return this.nomDivisa;
    }

    public float getValorDivisa() {
        return this.valorDivisa;
    }

    public void setValorDivisa(float valorDivisa) {
        this.valorDivisa = valorDivisa;
    }

    public boolean isDivisaInicialitzada() {
        return this.divisaInicialitzada;
    }

    public void setDivisaInicialitzada(boolean divisaInicialitzada) {
        this.divisaInicialitzada = divisaInicialitzada;
    }
}
