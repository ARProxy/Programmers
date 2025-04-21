import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 집의 수
        int[][] costs = new int[n][3]; // 각 집을 R, G, B로 칠하는 비용
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                costs[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][3]; // DP 테이블
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i]; // 첫 번째 집을 칠하는 비용 초기화
        }

        // DP 테이블 갱신
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0]; // i번째 집을 R로 칠하는 경우
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1]; // G로 칠하는 경우
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2]; // B로 칠하는 경우
        }

        // 마지막 집을 각각의 색으로 칠했을 때의 최소 비용 중 최솟값을 출력
        System.out.println(Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]));

        sc.close();
    }
}
