package br.inatel.cdg.processar;

import br.inatel.cdg.computador.Computador;

public class ProcessarPedido {
    public static void processarPedido(Computador[] computador, int quantidade){
        if(quantidade == 0){
            System.out.println("Nao houve compras");
            System.out.println();
        }else{
        System.out.println("Pedido enviado...");
        System.out.println();
        }
        for(int i = 0; i < quantidade; i++){
            computador[i].mostrarPCConfigs();
            System.out.println();
        }
    }
}
