import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    List<GenericCar> carros = new ArrayList<>();

    // Construindo os carros
    GenericCar civic = new Civic();
    civic.Construtor();
    GenericCar golf = new Golf();
    golf.Construtor();
    GenericCar corolla = new Corolla();
    corolla.Construtor();

    // Adicionando a Lista
    carros.add(civic);
    carros.add(corolla);
    carros.add(corolla);
    carros.add(golf);
    carros.add(civic);

    // Imprimindo a Lista
    System.out.println(carros);

  }
}
