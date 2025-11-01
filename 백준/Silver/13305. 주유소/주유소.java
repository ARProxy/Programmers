import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] distance = new int[n-1];
        int[] money = new int[n];

        for (int i = 0; i < n - 1; i++) {
            distance[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            money[i] = sc.nextInt();
        }

        long sum = 0;
        int currentMin = money[0];

        for (int i = 0; i < n - 1; i++) {
            if (money[i] < currentMin) {
                currentMin = money[i];
            }
            sum += (long) currentMin * distance[i];
        }
        System.out.println(sum);
    }
}
