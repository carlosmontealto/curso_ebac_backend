package br.com.calto.factory;

public abstract class Factory {
    public Car criarVenda(Long ano, String modelo){
        System.out.println("Iniciando a venda do veiculo: ");
        return preparandoVendaVeiculo(ano, modelo);
    }

    protected abstract Car preparandoVendaVeiculo(Long ano, String modelo);
}
