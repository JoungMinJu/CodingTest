package Reis.twoPointer_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;
        int sum = 0;
        int lt = 0;
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int rt = 0; rt < N; rt++) {
            sum += A[rt];
            if (sum == M) {
                answer++;
            }
            while (sum >= M) {
                sum -=A[lt++];
                if (sum == M) {
                    answer ++;
                }
            }
        }
        System.out.println(answer);
    }
}
