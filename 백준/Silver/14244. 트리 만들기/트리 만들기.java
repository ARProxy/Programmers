import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        int internal = n - m;

        for (int i = 0; i < internal - 1; i++) {
            sb.append(i).append(' ').append(i + 1).append('\n');
        }

        int next = internal;

        if (internal == 1) {
            for (int i = 0; i < m; i++) {
                sb.append(0).append(' ').append(next++).append('\n');
            }
        } else {
            sb.append(0).append(' ').append(next++).append('\n');
            for (int i = 1; i < m; i++) {
                sb.append(internal - 1).append(' ').append(next++).append('\n');
            }
        }

        System.out.print(sb);
    }
}