package HighScoreKit;
import java.util.*;

public class SortLongestNumber {
    class Solution {
        public String solution(int[] numbers) {
            String answer = "";

            List<String> listNumber = new ArrayList<>();

            for(int num : numbers) {
                listNumber.add(String.valueOf(num));
            }

            listNumber.sort((a, b) -> (b + a).compareTo(a + b));

            for(String s : listNumber) {
                answer += s;
            }

            if(answer.charAt(0) == '0')
                answer = "0";

            return answer;
        }
    }
}
