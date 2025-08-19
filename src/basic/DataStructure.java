package basic;

import java.util.*;

public class DataStructure {
    public static void main(String[] args) {
        // LIST : 삭제 O(1) / O(N), 조회 O(1)
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(1, 15);
        System.out.println(list);

        list.remove(1);
        System.out.println(list.get(0));

        Collections.sort(list);
        list.sort(Comparator.reverseOrder());

        // HashSet : 순서 없는 대신, 나머지 연산 O(1) 보장
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("apple");  // 중복 무시
        System.out.println(set); // [apple, banana]

        // TreeSet : 정렬 상태 유지 대신, O(logN) 보장
        //Set<Integer> tree = new TreeSet<>();
        Set<Integer> tree = new TreeSet<>(Comparator.reverseOrder());
        tree.add(5);
        tree.add(1);
        tree.add(3);
        tree.add(3);
        System.out.println(tree); // [1, 3, 5] (자동 정렬)
        System.out.println(tree.size());

        // HashMap : 순서 없음, 평균 O(1) 보장
        Map<String, Integer> map = new HashMap<>();
        map.put("kim", 90);
        map.put("lee", 80);
        map.put("park", 85);

        System.out.println(map.get("kim"));
        System.out.println(map.containsKey("lee"));

        for(String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        // TreeMap : 순서 보장, 평균 O(logN) 보장
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "c");
        treeMap.put(1, "a");
        treeMap.put(2, "b");
        System.out.println(treeMap); // {1=a, 2=b, 3=c}

        // Stack : LIFO
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek()); // 30 (맨 위 확인)
        System.out.println(stack.pop());  // 30 (맨 위 꺼내기)
        System.out.println(stack);        // [10, 20]

        // Queue : FIFO
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.peek()); // 1
        System.out.println(queue.poll()); // 1 (꺼내기)
        System.out.println(queue);        // [2, 3]

        // PriorityQueue 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소 힙
        pq.add(5);
        pq.add(1);
        pq.add(3);
        System.out.println(pq.poll()); // 1
        System.out.println(pq.poll()); // 3

        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
        maxPq.add(5);
        maxPq.add(1);
        maxPq.add(3);
        System.out.println(maxPq.poll()); // 5

        // Deque 양쪽 삽입/삭제 가능
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(10); // 앞에 추가
        dq.addLast(20);  // 뒤에 추가
        System.out.println(dq); // [10, 20]

        System.out.println(dq.pollFirst()); // 10
        System.out.println(dq.pollLast());  // 20

        // StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" World");
        System.out.println(sb.toString()); // Hello World
        sb.reverse();
        System.out.println(sb.toString()); // dlroW olleH
    }
}
