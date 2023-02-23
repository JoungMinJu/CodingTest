package Reis.twoPointer_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003_plus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;
        int sum = 0;
        int lo =0, hi = 0;
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        while(true) {
            if (sum >= M)
                sum -= A[lo++];
            else if(hi == N) {
                break;
            }
            else {
                sum += A[hi++];
            }
            if (sum == M) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
