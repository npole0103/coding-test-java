package HighScoreKit;
import java.util.*;

public class BruteForceFindPrimeNumber {
    class Solution {
        Set<String> set = new HashSet<>();

        public boolean isPrime(int num) {
            if (num == 1) return false;

            for(int i = 2; i < num ; i++) {
                if(num % i == 0)
                    return false;
            }
            return true;
        }

        void dfs(int[] arr, boolean[] visited, List<Integer> result, int r) {
            if(result.size() == r) {
                if(result.get(0) == 0)
                    return;

                String s = "";
                for(Integer num : result) {
                    s += String.valueOf(num);
                }

                set.add(s);
                return;
            }

            for(int i = 0; i < arr.length; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    result.add(arr[i]);
                    dfs(arr, visited, result, r);
                    result.remove(result.size() - 1);
                    visited[i] = false;
                }
            }
        }

        public int solution(String numbers) {
            int answer = 0;

            int[] arr = new int[numbers.length()];

            for(int i = 0; i < numbers.length(); i++) {
                arr[i] = numbers.charAt(i) - 48;
            }

            for(int i = 1; i <= numbers.length(); i++) {
                dfs(arr, new boolean[arr.length], new ArrayList<>() , i);
            }

            for(String s : set) {
                answer += isPrime(Integer.valueOf(s)) ? 1 : 0;
            }

            return answer;
        }
    }
}
