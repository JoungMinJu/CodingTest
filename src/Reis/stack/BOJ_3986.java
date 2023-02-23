package Reis.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        String input;
        char now;

        int N = Integer.parseInt(br.readLine()); // 단어의 수
        for (int i = 0; i < N; i++) {
            stack.clear();
            input = br.readLine();
            for (int c = 0; c < input.length(); c++){
                now = input.charAt(c);
                if (stack.isEmpty() || stack.peek() != now) {
                    stack.push(now);
                } else if (stack.peek() == now) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }
        System.out.println(answer);

    }
}
