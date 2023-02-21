package Reis.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Deque<Integer> que = new LinkedList<>();
        String command;
        int num;

        int N = Integer.parseInt(br.readLine()); // 명령의 개수
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            switch (command) {
                case "push":
                    num = Integer.parseInt(st.nextToken());
                    que.add(num);
                    break;
                case "pop":
                    if (que.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(que.pop());
                    }
                    break;
                case "size":
                    System.out.println(que.size());
                    break;
                case "empty":
                    System.out.println((que.isEmpty()) ? 1 : 0);
                    break;
                case "front":
                    if (que.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(que.peekFirst());
                    }
                    break;
                case "back":
                    if (que.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(que.peekLast());
                    }
                    break;
            }
        }
    }
}
