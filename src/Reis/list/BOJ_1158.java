package Reis.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        List<Integer> answer = new LinkedList<>();

        for (int num = 1; num <=N; num++){
            deque.add(num);
        }

        for (int cnt = 1; cnt <= N; cnt++) {
            for (int turn = 1; turn < K; turn++) {
                deque.addLast(deque.poll());
            }
            answer.add(deque.poll());
        }

        System.out.println(answer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "<", ">")));
    }
}
