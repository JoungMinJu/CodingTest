package Algorithm_Two.CH13;// 프로그램 10.1: 분기 한정을 이용하여 배낭 채우기 문제를 해결하는 프로그램
import Algorithm_Two.CH13.Node;

import java.util.*;

public class KnapsackBandB {
    public int maxValue;  	// 현재까지 찾은 최고 해의 값
    public int N;			// 물건들의 수
    public int C;			// 배낭의 용량
    public int[] Wt;		// 각 물건의 무게를 저장하는 배열
    public int[] Val;		// 각 물건의 가치를 저장하는 배열

    public PriorityQueue<Node> queue;  // 상태 공간 트리를 대신하는 우선 순위 대기열

    // 노드 u의 한계값을 계산한다
    public int computeBound(Node u) {
        if (u.weight >= C) return 0;
        else if (u.level < N)
            return u.value + (C - u.weight)*(Val[u.level]/Wt[u.level]);
        else return u.value;
    }

    // 객체 변수들의 값들을 주어진 값으로 초기화하면서 우선 순위 대기열을 만든다
    public KnapsackBandB(int num, int[] wt, int[] val, int cap) {
        queue = new PriorityQueue<Node>();  // 우선 순위 대기열을 만든다
        maxValue = 0;
        N = num;
        C = cap;
        Wt = wt;
        Val = val;
    }

    // N개의 물건들 중에서 배낭의 용량 C를 초과하지 않고 배낭에 넣을 수 있는 물건들의 최대 가치를 계산한다
    public int knapsack() {
        Node root = new Node();
        root.bound = computeBound(root);  // 루트 노드의 한계값을 계산한다

        // 루트 노드를 queue(우선 순위 대기열)에 집어 넣는다
        queue.add(root);

        // queue가 비어 있지 않은 동안 반복한다
        while(!queue.isEmpty()) {
            // 최대 한계값을 가진 노드 temp를 queue에서 끄집어 낸다
            Node temp = queue.remove();

            if(temp.bound > maxValue) { // 노드 temp가 유망하면 확장한다
                // 다음 물건을 넣는 경우에는 노드 u를 자식 노드로 만든다
                Node u = new Node();
                u.level = temp.level + 1;
                u.weight = temp.weight + Wt[temp.level];
                u.value = temp.value + Val[temp.level];
                if (u.weight <= C && u.value > maxValue)
                    // maxValue를 더 나은 해의 값으로 바꾼다
                    maxValue = u.value;

                u.bound = computeBound(u); // 자식 노드의 한계값을 계산한다

                if (u.bound > maxValue)
                    queue.add(u);  // u가 유망하므로 queue에 집어 넣는다

                // 다음 물건을 넣지 않는 경우에는 노드 w를 자식 노드로 만든다
                Node w = new Node();
                w.level = temp.level + 1;
                w.weight = temp.weight;
                w.value = temp.value;

                w.bound = computeBound(w); // 자식 노드의 한계값을 계산한다

                if (w.bound > maxValue)
                    queue.add(w);	// w가 유망하므로 queue에 집어 넣는다
            }
        }

        return maxValue;
    }

    // 시작 메소드
    public static void main(String[] args) {
        int[] wt = {12, 14, 15};	// 물건들의 무게를 저장하는 배열
        int[] val = {72, 70, 60};	// 물건들의 가치를 저장하는 배열

        // 객체 변수들의 값들을 초기화하면서 KnapsackBandB 객체를 생성한다
        KnapsackBandB kbb = new KnapsackBandB(3, wt, val, 30);

        // 분기 한정을 이용하여 배낭에 넣을 수 있는 물건들의 최대 가치를 계산한 후 출력한다
        System.out.println("배낭에 넣을 수 있는 물건들의 최대 가치 = " + kbb.knapsack());
    }
}