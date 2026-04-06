package br.inatel.cdg;

import br.inatel.cdg.cliente.Cliente;
import br.inatel.cdg.computador.Computador;
import br.inatel.cdg.hardware.HardwareBasico;
import br.inatel.cdg.memoria.MemoriaUSB;
import br.inatel.cdg.processar.ProcessarPedido;
import br.inatel.cdg.sistema.SistemaOperacional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int matricula = 689;

        HardwareBasico[] hw1 = {
            new HardwareBasico("Pentium Core i3", 2200),
            new HardwareBasico("Memoria RAM", 8),
            new HardwareBasico("HD", 500)
        };
        Computador pc1 = new Computador("Apple", 0 + matricula, hw1, new SistemaOperacional("macOS Sequoia", 64));
        pc1.addMemoriaUSB(new MemoriaUSB("Pen-drive ", 16));

        HardwareBasico[] hw2 = {
            new HardwareBasico("Pentium Core i5", 3370),
            new HardwareBasico("Memoria RAM", 16),
            new HardwareBasico("HD", 1000)
        };
        Computador pc2 = new Computador("Samsung", 1234 + matricula,hw2, new SistemaOperacional("Windows 8", 64) );
        pc2.addMemoriaUSB(new MemoriaUSB("Pen-drive ", 32));

        HardwareBasico[] hw3 = {
            new HardwareBasico("Pentium Core i7", 4500),
            new HardwareBasico("Memoria RAM", 32),
            new HardwareBasico("HD", 2000)
        };
        Computador pc3 = new Computador("Dell", 5678 + matricula, hw3,new SistemaOperacional("Windows 10", 64));
        pc3.addMemoriaUSB(new MemoriaUSB("HD Externo ", 1000));

        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite seu CPF: ");
        String cpf = sc.nextLine();

        Cliente cliente = new Cliente(nome, cpf, 25);

        System.out.println("---");
        System.out.println("Promoção 1:");
        pc1.mostrarPCConfigs();
        System.out.println("---");
        System.out.println("Promoção 2:");
        pc2.mostrarPCConfigs();
        System.out.println("---");
        System.out.println("Promoção 3:");
        pc3.mostrarPCConfigs();
        System.out.println("---");

        int opcao;
        do { 
            System.out.println("Escolha a promoção que deseja (1, 2 ou 3), caso não goste de nenhuma digite 0 para sair:");
            opcao = sc.nextInt();

            switch(opcao){
                case 1:
                    cliente.comprarComputador(pc1);
                   break;
                case 2:
                    cliente.comprarComputador(pc2);
                    break;
                case 3:
                    cliente.comprarComputador(pc3);
                    break;

                case 0:
                    break;
                    default: System.out.println("Opção inexistente");
            }
        } while (opcao != 0);

        System.out.println("---");
        ProcessarPedido.processarPedido(cliente.getComputador(), cliente.getQuantidade());
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Sua compra ficou no valor de: " + cliente.calculaTotalCompra() + " R$");
        System.out.println();

        sc.close();
    }
}
