package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11727_td {
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1];

        System.out.println(getAnswer(N));
    }

    private static int getAnswer(int N) {
        if (N == 0 || N ==1 ){
            return 1;
        }
        if (dp[N] > 0){
            return dp[N];
        }
        dp[N] = (getAnswer(N-1) + 2*getAnswer(N-2)) % 10007;
        return dp[N];
    }
}
