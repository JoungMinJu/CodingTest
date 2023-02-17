package Reis.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split("");

        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        for (String s : str) {
            left.push(s);
        }

        int M = Integer.parseInt(br.readLine()); // 입력할 명령어의 개수
        for (int i = 0; i < M; i++) {
            String[] commands= br.readLine().split(" ");
            char command = commands[0].charAt(0);

            if (command == 'L') {
                if (!left.isEmpty())
                    right.push(left.pop());
            }
            else if (command == 'D') {
                if (!right.isEmpty())
                    left.push(right.pop());
            }
            else if (command == 'B') {
                if (!left.isEmpty())
                    left.pop();
            }
            else if (command == 'P') {
                left.push(commands[1]);
            }
        }

        while (!left.isEmpty())
            right.push(left.pop());

        while (!right.isEmpty())
            sb.append(right.pop());

        System.out.println(sb.toString());
    }
}
