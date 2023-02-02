package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1904_td {
    public static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new long[N+2];

        System.out.println(getAnswer(N));
    }

    private static long getAnswer(int n) {
        if (n == 0 || n == 1 || n == 2)
            return n;
        if (dp[n] > 0)
            return dp[n];
        dp[n] = (getAnswer(n-1) + getAnswer(n-2)) % 15746;
        return dp[n] ;
    }
}
