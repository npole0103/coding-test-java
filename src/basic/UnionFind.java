package basic;

public class UnionFind {
    private int[] parent;
    
    // 초기화 n개 노드
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // Find 연산
    public int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // Union 연산
    public void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[b] = a;
        }
        else {
            parent[a] = b;
        }
    }

    public boolean findParent(int a, int b) {
        return find(a) == find(b);
    }

    // 디버깅용 배열 상태 출력
    public void printParents() {
        System.out.print("Index : ");
        for (int i = 0; i < parent.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("Parent: ");
        for (int i = 0; i < parent.length; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();

        System.out.print("Root  : ");
        for (int i = 0; i < parent.length; i++) {
            System.out.print(find(i) + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(6);

        uf.union(0, 1);
        uf.union(1,2);
        uf.union(3, 4);

        System.out.println(uf.findParent(0, 1));
        System.out.println(uf.findParent(0, 3));

        uf.printParents();
    }
}
