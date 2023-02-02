package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+2];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i<=N ; i++){
            dp[i] = (dp[i-1]+dp[i-2]) % 15746;
        }
        System.out.println(dp[N]);
    }
}
