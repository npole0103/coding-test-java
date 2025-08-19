package basic;

import java.util.Arrays;

public class Greedy {
    public static void main(String[] args) {
        int[][] meetings = {{1, 4}, {3, 5}, {0, 6}, {5, 7}, {3, 8}, {8, 9}};

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[1], b[1])
        );

        int count = 0, end = 0;
        for(int[] m : meetings) {
            if(m[0] >= end) {
                count++;
                end = m[1];
            }
        }
        System.out.println("최대 회의 수 : " + count);
    }
}
