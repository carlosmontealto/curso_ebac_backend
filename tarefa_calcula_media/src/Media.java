import java.util.Scanner;

public class Media {

    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;

    public Media(double nota1, double nota2, double nota3, double nota4) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
    }

    public double calcularMedia() {
        return (nota1 + nota2 + nota3 + nota4) / 4;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a primeira nota: ");
        double nota1 = s.nextDouble();
        System.out.println("Digite a segunda nota: ");
        double nota2 = s.nextDouble();
        System.out.println("Digite a terceira nota: ");
        double nota3 = s.nextDouble();
        System.out.println("Digite a quarta nota: ");
        double nota4 = s.nextDouble();
        Media media = new Media(nota1, nota2, nota3, nota4);
        System.out.println("A média das notas é: " + media.calcularMedia());
    }
}
