package br.com.calto.factory;

import java.util.Scanner;

public class App {

    public static void main (String[] args) {
        Cliente cliente = new Cliente();
        Scanner scanner = new Scanner(System.in);
        System.out.println("**** Iniciando o programa ****");
        System.out.println("Digite o modelo do veículo que o cliente deseja (opções: civic, corolla, golf");
        cliente.setModelo(scanner.nextLine());
        System.out.println("Digite o ano do veículo que o cliente deseja") ;
        cliente.setAno(Long.getLong(scanner.nextLine()));
        System.out.println("Opção escolhida pelo cliente: Carro= " +
                cliente.getModelo() + " Ano= " + cliente.getAno());


    }
}
