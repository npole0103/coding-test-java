package HighScoreKit;
import java.util.*;

public class BruteForcePowerWeb {
    class Solution {

        public int getParent(int[] parent, int x) {
            if(parent[x] == x) {
                return x;
            }
            return parent[x] = getParent(parent, parent[x]);
        }

        public void union(int[] parent, int a, int b) {
            a = getParent(parent, a);
            b = getParent(parent, b);

            if(a < b) {
                parent[b] = a;
            }
            else {
                parent[a] = b;
            }
        }

        public int solution(int n, int[][] wires) {
            int answer = Integer.MAX_VALUE; // 최소값을 찾으므로 크게 시작
            int m = wires.length;

            for (int cut = 0; cut < m; cut++) {
                // 1) parent 초기화
                int[] parent = new int[n + 1];
                for (int i = 0; i <= n; i++) parent[i] = i;

                // 2) cut 간선을 제외하고 union 수행
                for (int i = 0; i < m; i++) {
                    if (i == cut) continue;
                    union(parent, wires[i][0], wires[i][1]);
                }

                // 3) 각 노드의 루트 기준으로 컴포넌트 크기 카운트
                Map<Integer, Integer> compSize = new HashMap<>();
                for (int v = 1; v <= n; v++) {
                    int root = getParent(parent, v);
                    compSize.put(root, compSize.getOrDefault(root, 0) + 1);
                }

                // 트리를 간선 하나 끊으면 반드시 부모 2개만 나옴
                for (int size : compSize.values()) {
                    int diff = Math.abs((n - size) - size);
                    answer = Math.min(answer, diff);
                    // 두 컴포넌트 중 하나만 보면 되므로 break 해도 됨
                    break;
                }
            }
            return answer;
        }
    }
}
