import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        for (String p : completion) {
            map.put(p, map.getOrDefault(p, 0) - 1);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) > 0) return key;
        }
        
        throw  new IllegalArgumentException("미완주자가 없습니다.");
    }
}