import java.util.Scanner;
import java.util.Random;
public class Ex3{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random gerador = new Random();
        int tentativas = 0;
        int number = (gerador.nextInt()%10)+1;
        int userNumber = 0;
        while(tentativas < 3 || userNumber != number){
            userNumber = Integer.parseInt(input.next());
            tentativas ++;
        }
        if(userNumber == number){
            System.out.println("Ganhou!");
        }else{
            System.out.println("Perdeu!");
        }
    }
}
