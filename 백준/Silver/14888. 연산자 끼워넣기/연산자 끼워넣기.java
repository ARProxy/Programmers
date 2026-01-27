import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] nums;
    static int[] ops = new int[4];
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine().trim());
        nums = new int[n];
        
        MyTokenizer mt = new MyTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = mt.nextInt();
        }
        
        mt = new MyTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = mt.nextInt();
        }
        
        dfs(1, nums[0]);
        
        System.out.println(maxResult);
        System.out.println(minResult);
    }
    
    static void dfs(int idx, int current) {
        if (idx == n) {
            maxResult = Math.max(maxResult, current);
            minResult = Math.min(minResult, current);
            return;
        }
        
        for (int op = 0; op < 4; op++) {
            if (ops[op] > 0) {
                ops[op]--;
                int next = calculate(current, nums[idx], op);
                dfs(idx + 1, next);
                ops[op]++;
            }
        }
    }
    
    static int calculate(int a, int b, int op) {
        switch (op) {
            case 0: return a + b;
            case 1: return a - b;
            case 2: return a * b;
            case 3: 
                if (a < 0) return -(-a / b);
                return a / b;
            default: return 0;
        }
    }
}

class MyTokenizer {
    private final char[] chars;
    private int pos;
    private final int len;
    
    public MyTokenizer(String str) {
        this.chars = str.toCharArray();
        this.len = chars.length;
        this.pos = 0;
    }
    
    private boolean isWhitespace(char c) {
        return c == ' ' || c == '\t' || c == '\n' || c == '\r';
    }
    
    private void skipWhitespace() {
        while (pos < len && isWhitespace(chars[pos])) {
            pos++;
        }
    }
    
    public boolean hasMoreTokens() {
        skipWhitespace();
        return pos < len;
    }
    
    public String nextToken() {
        skipWhitespace();
        
        if (pos >= len) {
            return null;
        }
        
        int start = pos;
        
        while (pos < len && !isWhitespace(chars[pos])) {
            pos++;
        }
        
        return new String(chars, start, pos - start);
    }
    
    public int nextInt() {
        skipWhitespace();
        
        boolean negative = false;
        int result = 0;
        
        if (pos < len && chars[pos] == '-') {
            negative = true;
            pos++;
        }
        
        while (pos < len && chars[pos] >= '0' && chars[pos] <= '9') {
            result = result * 10 + (chars[pos] - '0');
            pos++;
        }
        
        return negative ? -result : result;
    }
}