import java.util.Random;
import java.util.Scanner;

class Chutes {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int tentativas = 3, numero = rand.nextInt(100)+1;
        
        while(tentativas-- != 0){
            System.out.print("Chute: ");
            int chute = input.nextInt();
            
            if(chute == numero) {
                System.out.println("\nAcertou mizeravi");
                break;
            } else {
                System.out.println("\nErrrrou");
            }
        }
    }
}