import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 개수
        
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(); // 순열의 크기 N
            int[] permutation = new int[N + 1]; // 순열을 저장할 배열
            boolean[] visited = new boolean[N + 1]; // 방문 여부를 표시하는 배열
            int cycles = 0; // 순열 사이클의 개수
            
            for (int i = 1; i <= N; i++) {
                permutation[i] = sc.nextInt();
            }
            
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    int current = i;
                    while (!visited[current]) {
                        visited[current] = true;
                        current = permutation[current];
                    }
                    cycles++;
                }
            }
            
            System.out.println(cycles);
        }
        
        sc.close();
    }
}
