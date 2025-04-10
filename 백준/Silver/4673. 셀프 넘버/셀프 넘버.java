public class Main {
    public static void main(String[] args) {
        int maxRange = 10000;
        boolean[] notSelfNum = new boolean[maxRange + 1];
        
        for(int i=1; i<=maxRange; i++) {
            int dn = d(i);    //숫자 i의 d(n) 계산
            if(dn <= maxRange) {
                notSelfNum[dn] = true;
            }
        }
        
        for(int i=1; i<=maxRange; i++) {
            if(!notSelfNum[i]) {
                System.out.println(i);
            }
        }
    }
    public static int d(int n) {
        int sum = n;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}