package Reis.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> que = new LinkedList<>();

        for (int num = 1; num <= N; num++){
            que.add(num);
        }

        while (que.size() >= 2) {
            que.poll();
            que.add(que.poll());
        }
        System.out.println(que.poll());
    }
}
