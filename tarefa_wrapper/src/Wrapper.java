import java.util.Locale;
import java.util.Scanner;

public class Wrapper {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    scanner.useLocale(Locale.US);
    System.out.println("Insira um numero inteiro: ");
    int numInt = scanner.nextInt();
    System.out.println("Insira um numero flutuante: ");
    double numFloat = scanner.nextDouble();
    Integer numInteger = Integer.valueOf(numInt);
    Double numDouble = Double.valueOf(numFloat);
    System.out.println("O numero inteiro é : " + numInteger);
    System.out.println("O numero flutuante é: " + numDouble);
    scanner.close();
  }
}
