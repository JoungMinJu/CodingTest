package Reis.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        int answer = 1;
        int tmp1, tmp2;

        for (int i= 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            tmp1 = Integer.parseInt(st.nextToken());            tmp2 = Integer.parseInt(st.nextToken());

            if (tmp1 == answer) {
                answer = tmp2;
            } else if (tmp2 == answer) {
                answer = tmp1;
            }
        }
        System.out.println(answer);
    }
}
