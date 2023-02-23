package Reis.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1966 {
    private static class Node {
        int index;
        int number;

        public Node(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Node> que = new LinkedList<>();

        int N, M, nowNumber, findNumber =0;
        Node nowNode;
        int answer = 0;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            pq.clear();
            que.clear();
            answer =0;
            st =  new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 문서의 개수
            M = Integer.parseInt(st.nextToken()); // 궁금한 문서의 현재 큐에서의 위치

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                nowNumber = Integer.parseInt(st.nextToken());
                pq.add(nowNumber);
                que.add(new Node(i, nowNumber));
                if (i == M) {
                    findNumber = nowNumber;
                }
            }

            while (!que.isEmpty()) {
                nowNode = que.peek();
                if (nowNode.number < pq.peek()) {
                    que.add(que.poll());
                } else if (nowNode.index != M ) {
                    answer++;
                    que.poll();
                    if (nowNode.number != findNumber) {
                        pq.poll();
                    }
                } else {
                    answer++;
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}
