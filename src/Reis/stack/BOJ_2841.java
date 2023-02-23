package Reis.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> now;
        int numberOfLine, numOfPlat;
        int answer = 0;

        Map<Integer, Stack<Integer>> stackByNumberOfLine = new HashMap<>();

        for (int numOfLine = 1; numOfLine <= 6; numOfLine++)
            stackByNumberOfLine.put(numOfLine, new Stack<>());

        int N = Integer.parseInt(st.nextToken()); // 포함되어있는 음의 수
        int P = Integer.parseInt(st.nextToken()); // 한 줄에 있는 프렛의 수 -> 기타는 1~6줄

        for (int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            numberOfLine = Integer.parseInt(st.nextToken());
            numOfPlat = Integer.parseInt(st.nextToken());

            now = stackByNumberOfLine.get(numberOfLine);

            if (now.isEmpty() || now.peek() < numOfPlat) {
                now.push(numOfPlat);
                answer++;
            }  else {
                while (true) {
                    if (now.isEmpty()) {
                        break;
                    }
                    else if (now.peek() <= numOfPlat) {
                        break;
                    }
                    now.pop();
                    answer++;
                }
                if (now.isEmpty() || now.peek() != numOfPlat) {
                    now.push(numOfPlat);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
