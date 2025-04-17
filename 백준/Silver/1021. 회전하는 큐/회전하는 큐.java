import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer> list = new ArrayList<>() {
            {
                for (int i = 0; i < M; i++) {
                    add(sc.nextInt());
                }
            }
        };

        LinkedList<Integer> queue = new LinkedList<>() {
            {
                for (int i = 0; i < N; i++) {
                    offer(i + 1);
                }
            }
        };

        int sum = 0;

        for (int target : list) {
            while (true) {
                if (queue.peek().equals(target)) {
                    queue.poll(); // 첫 번째 원소를 뽑아낸다.
                    break;
                } else {
                    int index = queue.indexOf(target);
                    int halfSize = queue.size() / 2;
                    if (index <= halfSize) {
                        // 왼쪽으로 이동
                        queue.addLast(queue.pollFirst());
                        sum++;
                    } else {
                        // 오른쪽으로 이동
                        queue.addFirst(queue.pollLast());
                        sum++;
                    }
                }
            }
        }

        System.out.println(sum);

        sc.close();
    }
}
