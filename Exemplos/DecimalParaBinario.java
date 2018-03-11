import java.util.Scanner;

public class DecimalParaBinario{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String bin = "";
        int decimal;
        System.out.printf("Digite um nº: ");
        decimal = input.nextInt();
        while(decimal > 0){
            if(decimal%2 == 0){
                bin = "0" + bin;
            }else{
                bin = "1" + bin;
            }
            decimal = decimal/ 2;

        }
        System.out.println(bin);
    }
}
