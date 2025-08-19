package HighScoreKit;
import java.util.*;

public class HashClothes {
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;

            Map<String, Integer> m = new HashMap<>();

            for(String[] sArray : clothes) {
                if(m.containsKey(sArray[1])) {
                    m.put(sArray[1], m.get(sArray[1]) + 1);
                }
                else {
                    m.put(sArray[1], 1);
                }
            }

            for(String key : m.keySet()) {
                answer *= (m.get(key) + 1);
            }

            return answer - 1;
        }
    }
}
