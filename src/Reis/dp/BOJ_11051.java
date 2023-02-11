package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long dp[][] = new long[N+1][K+1];

        for(int k = 0; k <=K; k++){
            for(int n = 1; n <= N; n++){
                if (k == 0) dp[n][k] = 1;
                else if (n == k) dp[n][k] = 1;
                else dp[n][k] = (dp[n-1][k-1] + dp[n-1][k]) % 10007;
            }
        }

        System.out.println(dp[N][K] % 10007);
    }
}
