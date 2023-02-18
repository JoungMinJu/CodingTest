package Reis.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] commands;
        String command;
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        for (int count = 0; count < N; count++ ) {
            commands = br.readLine().split(" ");
            command = commands[0];

            switch(command) {
                case "push" :
                    stack.add(Integer.parseInt(commands[1]));
                    break;
                case "pop" :
                    System.out.println((stack.isEmpty()) ? "-1" : stack.pop());
                    break;
                case "size" :
                    System.out.println(stack.size());
                    break;
                case "empty" :
                    System.out.println((stack.isEmpty() ? "1" : "0"));
                    break;
                case "top" :
                    System.out.println((stack.isEmpty() ? "-1" : stack.peek()));
                    break;
            }
        }
    }
}
