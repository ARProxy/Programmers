import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>();
        int last = 0;

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            if (str.length > 1) {
                if (str[0].equalsIgnoreCase("push")) {
                    last = Integer.parseInt(str[1]);
                    queue.add(last);
                }
            } else {
                switch (str[0]) {
                    case "front":
                        sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
                        break;
                    case "back":
                        sb.append(queue.isEmpty() ? -1 : last).append('\n');
                        break;
                    case "pop":
                        sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
                        break;
                    case "size":
                        sb.append(queue.size()).append('\n');
                        break;
                    case "empty":
                        sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                        break;
                }
            }
        }

        System.out.print(sb);
    }
}