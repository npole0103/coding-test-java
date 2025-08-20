package HighScoreKit;
import java.util.*;

public class SortHIndex {
    class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            int n = citations.length;

            List<Integer> list = new ArrayList<>();
            for(int num : citations)
                list.add(num);

            list.sort((a, b) -> a.compareTo(b));

            // 첫번째 값이 n보다 크거나 같다면
            if(list.get(0) >= n) {
                return n;
            }

            for(int i = 0; i < n; i++) {
                if(list.get(i) >= (n - i)) {
                    continue;
                }
                answer = n - i - 1;
            }

            return answer;
        }
    }
}
