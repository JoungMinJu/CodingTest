package Reis.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Deque<Integer> dq = new LinkedList<>();
        String command;
        int number;

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            switch (command) {
                case "push_front" :
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front" :
                    System.out.println((dq.isEmpty()) ? -1 : dq.pollFirst());
                    break;
                case "pop_back" :
                    System.out.println((dq.isEmpty()) ? -1 : dq.pollLast());
                    break;
                case "size" :
                    System.out.println(dq.size());
                    break;
                case "empty" :
                    System.out.println((dq.isEmpty()) ? 1 : 0);
                    break;
                case "front" :
                    System.out.println((dq.isEmpty()) ? -1 : dq.peekFirst());
                    break;
                case "back" :
                    System.out.println((dq.isEmpty() ? -1 : dq.peekLast()));
                    break;
            }
        }
    }
}
