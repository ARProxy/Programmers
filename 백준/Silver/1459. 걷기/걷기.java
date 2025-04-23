import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = sc.nextLong();
        long w = sc.nextLong();
        long s = sc.nextLong();       
        long min = Integer.MAX_VALUE;

        long time = (x+y) * w; //전부 직선
        min = Math.min(time, min);

        if(2*w < s) { //직선으로만
            time = (x+y) * w;
        }
        else if(w>s) { //최대한 대각선으로
            if((x+y) % 2 ==0) { //짝수
                time = Math.max(x, y)*s;
            }
            else { // 홀수
                time = (Math.max(x, y)- 1) *s;
                time += w;
            }
        }
        else {
            if(x == y) {
                time = s * x;
            }
            else {
                time = Math.min(x*s, y*s);
                time += Math.abs(x-y)*w;
            }
        }
        System.out.println(time);
        sc.close();
    }
}