package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int values[] = new int[N+1];
        int dp[][] = new int[N+1][N+1];

        for (int i = 1; i<=N; i++){
            values[i] = Integer.parseInt(st.nextToken());
        }

        for (int total = 1; total <= N; total++){
            for (int pack = 1; pack <=N; pack++){
                if (pack == 1)
                    dp[total][pack] = total * values[pack];
                else if (pack > total)
                    dp[total][pack] = dp[total][pack-1];
                else {
                    dp[total][pack] = Math.max(dp[total][pack-1], values[pack] + dp[total-pack][pack]);
                }
            }
        }
        System.out.println(dp[N][N]);
    }
}
