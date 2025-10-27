import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int pay = 1000;
        var scanner = new Scanner(System.in);
        int money = Integer.parseInt(scanner.nextLine());
        
        int result = 0;
        var payback = new int[] {500, 100, 50, 10, 5, 1};
        
        int minusPay = pay - money;
        
        for (int i = 0; i < payback.length; i++) {
            result += minusPay / payback[i];
            minusPay %= payback[i];
        }
        
        System.out.println(result);
        scanner.close();
    }
}