package com.example.marcobook.model;

public class Livro{
    private String nome;

    private String preco;

    private int quant_vendas;

    public Livro() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() { return preco; }

    public void setPreco(String preco) { this.preco = preco; }

    public int getQuant_vendas() { return quant_vendas; }

    public void setQuant_vendas(int quant_vendas) { this.quant_vendas = quant_vendas; }

}
