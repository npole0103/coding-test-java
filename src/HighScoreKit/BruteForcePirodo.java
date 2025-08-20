package HighScoreKit;
import java.util.*;

public class BruteForcePirodo {
    class Solution {

        public static int answer = Integer.MIN_VALUE;

        public void dfs(int[][] dungeons, boolean[] visited, List<int[]> result, int r, int k){
            if(result.size() == r) {
                int cnt = 0;
                int piro = k;

                for(int[] arr : result) {
                    if(piro >= arr[0]) {
                        piro -= arr[1];
                        cnt += 1;
                    }
                    else {
                        break;
                    }
                }
                answer = Math.max(answer, cnt);
            }

            for(int i = 0; i < dungeons.length; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    result.add(dungeons[i]);
                    dfs(dungeons, visited, result, r, k);
                    visited[i] = false;
                    result.remove(result.size() - 1);
                }
            }
        }

        public int solution(int k, int[][] dungeons) {

            for(int i = 1; i <= dungeons.length; i++) {
                dfs(dungeons, new boolean[dungeons.length], new ArrayList<>(), i, k);
            }

            return answer;
        }
    }
}
