package study.H;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input=null;
        while ((input=br.readLine()) != null) {
            int n = Integer.parseInt(input);
            sb.append(find(n));
        }
        System.out.println(sb.toString());
    }

    private static int find(int n) {
        int answer = 1;
        long div = 1;
        while (div % n != 0) {
            div += Math.pow(10, answer++);
        }
        return answer;
    }
}
