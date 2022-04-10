package Algorithm_Two.CH3.heap_prof;

import java.util.PriorityQueue;

public class PriQue {
    public static void main(String[] args) {
        // int 형 priorityQueu 선언(우선순위가 낮은 숫자 순)
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(3);
        priorityQueue.add(4);
        priorityQueue.add(1);
        priorityQueue.add(10);

        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}
