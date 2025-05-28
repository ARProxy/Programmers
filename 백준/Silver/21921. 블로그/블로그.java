import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 5
        int x = sc.nextInt(); // 2

        int[] blog = new int[n];
        for (int i = 0; i < n; i++) {
            blog[i] = sc.nextInt();
        }

        int[] result = new int[n + 1];
        for (int i = 1; i < result.length; i++) {
            result[i] = blog[i - 1] + result[i - 1];
        }

        int max = 0;
        int day = 0;
//        int[] days = new int[result.length];
        List<Integer> days = new ArrayList<>();
        for (int i = x; i < result.length; i++) {
//            days[i-x] = result[i] - result[i - x];
            days.add(result[i] - result[i - x]);
//            if(max == result[i] - result[i - x]) {
//                ++day;
//            }
//            max = Math.max(result[i] - result[i - x], max);
//            if(max == 0) {
//                System.out.println("SAD");
//                return;
//            }
        }

        int mmm = Collections.max(days);
        if(mmm == 0) {
            System.out.println("SAD");
        } else {
            for (int num : days) {
                if(mmm == num) {
                    day++;
                }
            }
            System.out.println(mmm);
            System.out.println(day);
        }


        sc.close();
    }
}
