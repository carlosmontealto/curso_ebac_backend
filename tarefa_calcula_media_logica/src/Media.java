import java.util.Locale;
import java.util.Scanner;

public class Media {

    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;

    private Media(double nota1, double nota2, double nota3, double nota4) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
    }

    private double calcularMedia() {
        return (nota1 + nota2 + nota3 + nota4) / 4;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        System.out.println("Digite a primeira nota: ");
        double nota1 = scanner.nextDouble();
        System.out.println("Digite a segunda nota: ");
        double nota2 = scanner.nextDouble();
        System.out.println("Digite a terceira nota: ");
        double nota3 = scanner.nextDouble();
        System.out.println("Digite a quarta nota: ");
        double nota4 = scanner.nextDouble();
        Media media = new Media(nota1, nota2, nota3, nota4);
        double mediaCalculada = media.calcularMedia();
        System.out.println("A média das notas é: " + mediaCalculada);
        System.out.println(media.resultado(mediaCalculada));
        scanner.close();
    }

    private String resultado(double media) {
        String resultado;
        if (media >= 7.0) {
            resultado = "Você foi aprovado";
        } else if (7.0 > media && media >= 5.0) {
            resultado = "Você está de recuperação";
        } else {
            resultado = "Você está reprovado";
        }
        return resultado;
    }
}
