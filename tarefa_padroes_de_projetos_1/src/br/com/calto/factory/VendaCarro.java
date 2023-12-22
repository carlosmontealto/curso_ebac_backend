package br.com.calto.factory;

public class VendaCarro extends Factory {

    @Override
    public Car preparandoVendaVeiculo(Long ano, String modelo) {
        Car car;
        if ("corolla".equals(modelo.toLowerCase())) {
            car = new CorollaCar(ano);
        } else if ("golf".equals(modelo.toLowerCase())) {
            car =  new GolfCar(ano);
        } else if ("civic".equals(modelo.toLowerCase())) {
            car = new CivicCar(ano);
        } else {
            car = null;
        }
        return car;
    }
}
