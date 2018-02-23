import java.util.Scanner;

class Salario {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = input.next();
        System.out.print("Horas trabalhadas: ");
        Float horas = input.nextFloat();
        System.out.print("Valor da hora: ");
        Float valor = input.nextFloat();
        System.out.printf("\nSalário = R$%.2f\n", valor*horas);
    }
}