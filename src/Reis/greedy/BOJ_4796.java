package Reis.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int L, V, P, c = 1, answer;

        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            if (L == 0 && P == 0 && V == 0)
                break;
            // 30일 -> 31일 동안 20일
            // 20일 -> 3

            answer = (V/P) * L + Math.min(L, V%P);
            System.out.println("Case " + c + ": " + answer );
            c++;
        }

    }
}
