import java.util.ArrayList;
import java.util.List;

public class PermComb {

    // 순열, 순서를 보장하며 중복 X
    public static void perm(int[] arr, boolean[] visited, List<Integer> results, int r) {
        if (results.size() == r) {
            System.out.println(results);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                results.add(arr[i]);
                perm(arr, visited, results, r);
                results.remove(results.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void comb(int[] arr, int start, List<Integer> results, int r) {
        if (results.size() == r) {
            System.out.println(results);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            results.add(arr[i]);
            comb(arr, i + 1, results, r);
            results.remove(results.size() - 1);
        }
    }

    public static void permDup(int[] arr, List<Integer> results, int r) {
        if (results.size() == r) {
            System.out.println(results);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            results.add(arr[i]);
            permDup(arr, results, r);
            results.remove(results.size() - 1);
        }
    }

    public static void combDup(int[] arr, int start, List<Integer> results, int r) {
        if (results.size() == r) {
            System.out.println(results);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            results.add(arr[i]);
            combDup(arr, i, results, r);
            results.remove(results.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int r = 2;

        System.out.println("=== 순열 ===");
        perm(arr, new boolean[arr.length], new ArrayList<>(), r);

        System.out.println("=== 조합 ===");
        comb(arr, 0, new ArrayList<>(), r);

        System.out.println("=== 중복 순열 ===");
        permDup(arr, new ArrayList<>(), r);

        System.out.println("=== 중복 조합 ===");
        combDup(arr, 0, new ArrayList<>(), r);
    }
}
