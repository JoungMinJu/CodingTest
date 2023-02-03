package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726_td {
    public static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1];

        System.out.println(getAnswer(N));
    }

    private static int getAnswer(int N) {
        if (N == 1 )
            return 1;
        if (N == 2)
            return 2;
        if (dp[N] > 0)
            return dp[N];
        dp[N] = getAnswer(N-1) + getAnswer(N-2);
        return dp[N] % 10007;
    }
}
