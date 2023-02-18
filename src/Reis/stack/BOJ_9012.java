package Reis.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        String input;
        char now, before;
        boolean success;

        for (int test = 0; test < T; test++){
            stack.clear();
            input = br.readLine();
            success = true;
            for (int i = 0; i<input.length(); i++) {
                now = input.charAt(i);
                if (now == '(') {
                    stack.push(now);
                } else {
                    if (stack.isEmpty()) {
                        success = false;
                        System.out.println("NO");
                        break;
                    }
                    before = stack.pop();
                    if (before != '(') {
                        success = false;
                        System.out.println("NO");
                        break;
                    }
                }
            }
            if (success) {
                System.out.println((stack.isEmpty() ? "YES" : "NO"));
            }
        }
    }
}
