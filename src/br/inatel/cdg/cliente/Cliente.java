package br.inatel.cdg.cliente;

import br.inatel.cdg.computador.Computador;

public class Cliente{
    private String nome;
    private String cpf;
    private int quantidade = 0;
    private Computador[] computador;

    public Cliente (String nome, String cpf, int maximo){
        this.nome = nome;
        this.cpf = cpf;
        this.computador = new Computador[maximo];
    }

    public void comprarComputador(Computador c){
        if(quantidade < computador.length){
            computador[quantidade] = c;
            quantidade++;
        }
    }

    public float calculaTotalCompra(){
        float total = 0;
        for(int i = 0; i < quantidade; i++){
            total += computador[i].getPreco();
        }
        return total;
    }


    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public Computador[] getComputador(){
        return computador;
    }

    public int getQuantidade(){
        return quantidade;
    }

}