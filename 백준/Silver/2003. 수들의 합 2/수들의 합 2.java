
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 숫자 배열의 길이
        int m = sc.nextInt(); // 찾고자 하는 특정 합

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt(); // 배열 입력 받기
        }

        int count = 0; // 조건을 만족하는 경우의 수
        int start = 0, end = 0, sum = 0; // 투 포인터 초기화

        while (true) {
            if (sum >= m) sum -= nums[start++]; // 현재 구간의 합이 m 이상이면 start를 오른쪽으로 이동
            else if (end == n) break; // end가 배열의 끝에 도달하면 반복 종료
            else sum += nums[end++]; // 그 외의 경우, end를 오른쪽으로 이동

            if (sum == m) count++; // 현재 구간의 합이 m과 같다면 카운트 증가
        }

        System.out.println(count);
        sc.close();
    }
}
