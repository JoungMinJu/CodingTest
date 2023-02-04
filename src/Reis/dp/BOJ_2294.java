package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        int[] dp = new int[k+1];

        for (int i= 0; i<n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp, 10001);

        dp[0] = 0;
        for (int coinIdx = 0; coinIdx < n; coinIdx++){
            for (int money = coins[coinIdx]; money <= k; money++){
                dp[money] = Math.min(dp[money], dp[money - coins[coinIdx]]+1);
            }
        }

        System.out.println((dp[k] != 10001 ? dp[k] : -1));

    }
}
