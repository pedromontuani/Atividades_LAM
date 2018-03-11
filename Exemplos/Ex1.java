import java.util.Scanner;
public class Ex1{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nome = "";
        int horas = 0;
        float valor = 0;
        System.out.println("Digite seu nome: ");
        nome = input.next();
        System.out.println("Digite o total de horas que o funcionario trabalhou: ");
        horas = Integer.parseInt(input.next());
        System.out.println("Digite o valor pago por hora: ");
        valor = Float.parseFloat(input.next());
        System.out.println("Total: R$"+ valor*horas);
    }
}
