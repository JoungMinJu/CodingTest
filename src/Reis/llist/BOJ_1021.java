package Reis.llist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 큐의 크기
        int M = Integer.parseInt(st.nextToken()); // 뽑아내려고 하는 수의 개수

        int answer = 0;

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++)
            deque.add(i);

        st = new StringTokenizer(br.readLine());
        for (int cnt = 0; cnt < M; cnt++) {
            int findNum = Integer.parseInt(st.nextToken());
            int findNumIndex = deque.indexOf(findNum);
            if(findNumIndex <= (deque.size()/2)) {
                while (deque.peek() != findNum) {
                    deque.addLast(deque.pollFirst());
                    answer++;
                }
                deque.pollFirst();
            }
            else {
               while (deque.peek() != findNum) {
                   deque.addFirst(deque.pollLast());
                   answer++;
               }
               deque.pollFirst();
            }
        }
        System.out.println(answer);
    }
}
