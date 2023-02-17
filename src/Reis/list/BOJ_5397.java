package Reis.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();
        String input;
        char inputChar;

        for (int test = 0; test < T; test++) {
            left.clear();
            right.clear();
            input = br.readLine();

            for (int i = 0; i < input.length(); i++) {
                inputChar = input.charAt(i);
                if (inputChar == '<') {
                    if (!left.isEmpty())
                        right.push(left.pop());
                } else if (inputChar == '>') {
                    if (!right.isEmpty())
                        left.push(right.pop());
                } else if (inputChar == '-') {
                    if (!left.isEmpty())
                        left.pop();
                } else {
                    left.push(String.valueOf(inputChar));
                }
            }

            while (!left.isEmpty())
                right.push(left.pop());

            while (!right.isEmpty())
                sb.append(right.pop());
            sb.append("\n");

            System.out.println(sb.toString());
        }
    }
}