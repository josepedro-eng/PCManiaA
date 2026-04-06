package br.inatel.cdg.computador;

import br.inatel.cdg.hardware.HardwareBasico;
import br.inatel.cdg.memoria.MemoriaUSB;
import br.inatel.cdg.sistema.SistemaOperacional;

public class Computador {
    private String marca;
    private float preco;
    private HardwareBasico[] hardware;
    private SistemaOperacional sistema;
    private MemoriaUSB memoria;

    public Computador(String marca, float preco,HardwareBasico[] hardware, SistemaOperacional sistema){
        this.marca = marca;
        this.preco = preco;
        this.hardware = hardware;
        this.sistema = sistema;
    }

    public void mostrarPCConfigs(){
        System.out.println("Marca: " + marca);
        System.out.println("Preco: " + preco);
        
        for(HardwareBasico hard: hardware){
          if (hard.getNome().contains("i3") || hard.getNome().contains("i5") || hard.getNome().contains("i7")) {
               System.out.println(hard.getNome() + " (" + hard.getCapacidade() + " MHz)");
            }else if (hard.getNome().contains("Memoria")) {
               System.out.println(hard.getCapacidade() + " Gb de " + hard.getNome());
            }else if (hard.getNome().contains("HD")) {
              System.out.println("" + hard.getCapacidade() + "Gb de " + hard.getNome());
            }
        }


        if(sistema != null){
            System.out.println("Sistema Operacional " + sistema.getNome() + " (" + sistema.getTipo() + " bits)");
        }
        if (memoria != null){
            System.out.println("Acompanha " + memoria.getNome() + "de " + memoria.getCapacidade() + "Gb");
        }
    }

    public void addMemoriaUSB(MemoriaUSB musb){
        this.memoria = musb;
    }

    public float getPreco(){
        return preco;
    }
}
