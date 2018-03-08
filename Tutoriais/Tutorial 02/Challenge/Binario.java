import java.util.Scanner;

class Binario {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Número: ");
        String result = bin(input.nextInt());
        result = new StringBuffer(result).reverse().toString();
        System.out.printf("\nBinário: %s\n", result);
    }

    public static String bin(int n){
        if(n/2 != 0){
            return Integer.toString(n%2) + bin(n/2);
        } else{
            return Integer.toString(n%2);
        }
    }
}