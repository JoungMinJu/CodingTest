package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        System.out.println(getAnswer(N));

    }

    private static int getAnswer(int n) {
        if (n == 1)
            return 0;
        if (dp[n] > 0)
            return dp[n];
        int result = getAnswer(n-1) +1;
        if (n % 3 == 0)
            result = Math.min(result, getAnswer(n/3)+1);
        if (n % 2 == 0)
            result = Math.min(result, getAnswer(n/2) +1);
        dp[n] = result;
        return dp[n];
    }
}
