package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2193_td {
    public static long dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new long[N+1];

        System.out.println(getDP(N));
    }

    private static long getDP(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (dp[n] > 0) {
            return dp[n];
        }
        dp[n] = getDP(n-1) + getDP(n-2);
        return dp[n];
    }
}
