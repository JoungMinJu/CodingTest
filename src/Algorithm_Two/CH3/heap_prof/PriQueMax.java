package Algorithm_Two.CH3.heap_prof;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriQueMax {
    public static void main(String[] args) {
        // 우선순위가 높은 숫자 순
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue.clear(); // priority queue 값 모두 삭제
        priorityQueue.add(3);
        priorityQueue.add(4);
        priorityQueue.add(1);
        priorityQueue.add(10);

        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}
