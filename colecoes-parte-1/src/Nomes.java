import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Nomes {

  public static void main(String[] args) {

    ordenarLista(criarLista());

  }

  private static List<String> criarLista() {
    Scanner scanner = new Scanner(System.in);
    List<String> listaNomes = new ArrayList<>();
    System.out.println("***** Vamos criar uma lista de nomes: ******");

    System.out.println("Digite os nomes separados por ', ': ");
    String scan = scanner.nextLine();
    String[] nomes = scan.split(", ");
    for (String nome : nomes) {
      listaNomes.add(nome);
    }

    scanner.close();
    return listaNomes;
  }

  private static void ordenarLista(List<String> lista) {
    System.out.println("***** Lista sem ordenar os nomes *****");
    System.out.println(lista);
    Collections.sort(lista);
    System.out.println("***** Lista ordenada *****");
    System.out.println(lista);

  }

}
