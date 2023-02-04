package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293_td {
    public static int[] coins;
    public static int[][] dp;
    public static int n,k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[n][k+1];
        coins = new int[n];

        for (int i = 0; i < n; i++)
            coins[i] = Integer.parseInt(br.readLine());
        
        System.out.println(getAnswer(n-1, k));
    }

    private static int getAnswer(int coinIndex, int targetMoney) {
        if (targetMoney < 0){
            return 0;
        }
        if (coinIndex == 0) {
            return (targetMoney % coins[coinIndex] != 0) ? 0 : 1;
        }
        if (dp[coinIndex][targetMoney] > 0) {
            return dp[coinIndex][targetMoney];
        }

        dp[coinIndex][targetMoney] = getAnswer(coinIndex-1, targetMoney) + getAnswer(coinIndex, targetMoney - coins[coinIndex]);
        return dp[coinIndex][targetMoney];
    }
}
