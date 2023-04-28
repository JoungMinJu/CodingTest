package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Swea_16800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int test = 1; test <= testCase; test++) {
            long answer = Long.MAX_VALUE;
            long N = Long.parseLong(br.readLine());
            for (int i = 1; i <= Math.sqrt(N); i++) {
                if (N % i != 0) {
                    continue;
                }
                answer = Math.min(answer, i - 1 + N / i - 1);
            }
            System.out.println(answer);
        }

    }
}
