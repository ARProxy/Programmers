import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt();
        Queue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new ArrayDeque<>(List.of(new AbstractMap.SimpleEntry<>(n, 0)));
        Set<Integer> visited = new HashSet<>(List.of(n));
        while (!queue.isEmpty()) {

            AbstractMap.SimpleEntry<Integer, Integer> temp = queue.poll();

            int current = temp.getKey();

            int level = temp.getValue();
            if (current == k) {
                System.out.println(level);
                break;
            }
            for (int child : new int[]{current - 1, current + 1, current * 2}) {
                if (child >= 0 && child <= 100000 && !visited.contains(child)) {
                    visited.add(child);
                    queue.offer(new AbstractMap.SimpleEntry<>(child, level + 1));
                }
            }
        }
        sc.close();
    }
}
