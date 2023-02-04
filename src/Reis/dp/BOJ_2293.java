package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int tmp;

        int[][] dp = new int[n][k+1];
        int[] coins = new int[n];

        for (int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);

        // 첫 번째 동전
        for(int money = 0; money <= k; money++){
            dp[0][money] = (money % coins[0] == 0) ? 1 : 0;
        }

        for (int coinIndex = 1; coinIndex < n; coinIndex++){
            for(int money = 0; money <= k; money ++ ) {
                tmp = (coins[coinIndex] > money) ? 0 : dp[coinIndex][money - coins[coinIndex]];
                dp[coinIndex][money] = tmp + dp[coinIndex-1][money];
            }
        }
        System.out.println(dp[n-1][k]);
    }
}
