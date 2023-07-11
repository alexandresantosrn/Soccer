package model;

public class Classificacao {
    private String time;
    private int pontos;
    private int golsMarcados;
    private int golsSofridos;

    public Classificacao(String time, int pontos, int golsMarcados, int golsSofridos) {
        this.time = time;
        this.pontos = pontos;
        this.golsMarcados = golsMarcados;
        this.golsSofridos = golsSofridos;
    }

    // Métodos getter e setter para os atributos

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getGolsMarcados() {
        return golsMarcados;
    }

    public void setGolsMarcados(int golsMarcados) {
        this.golsMarcados = golsMarcados;
    }

    public int getGolsSofridos() {
        return golsSofridos;
    }

    public void setGolsSofridos(int golsSofridos) {
        this.golsSofridos = golsSofridos;
    }
}