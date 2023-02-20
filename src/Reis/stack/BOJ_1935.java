package Reis.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BOJ_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 피연산자의 개수
        String input = br.readLine();

        Map<Character, Integer> numberByAlphabet = new HashMap<>();
        Stack<Double> answer = new Stack<>();
        Character alphabet = 'A';

        for (int i = 0; i<N; i++){
            numberByAlphabet.put(alphabet++, Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i<input.length(); i++){
            char now = input.charAt(i);
            if (Character.isAlphabetic(now)) {
                answer.add((double)numberByAlphabet.get(now));
            }
            else {
                double y = answer.pop();
                double x = answer.pop();
                answer.add(calculate(x, y, now));
            }
        }
        System.out.printf("%.2f", answer.pop());
    }

    private static double calculate(double x, double y, char operator) {
        if (operator == '+') return x + y;
        if (operator == '-') return x - y;
        if (operator == '*') return x * y;
        if (operator == '/') return x / y;
        return 0;
    }
}
