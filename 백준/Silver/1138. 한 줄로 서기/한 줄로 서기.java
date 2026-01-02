import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] left = new int[N];

        for (int i = 0; i < N; i++) {
            left[i] = sc.nextInt();
        }

        List<Integer> line = new ArrayList<>();

        for (int height = N; height >= 1; height--) {
            int idx = left[height - 1];
            line.add(idx, height);  
        }

        for (int h : line) {
            System.out.print(h + " ");
        }
    }
}