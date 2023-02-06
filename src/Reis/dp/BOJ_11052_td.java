package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052_td {
    public static int values[];
    public static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        values = new int[N+1];
        dp = new int[N+1][N+1];

        for (int i = 1; i<=N; i++){
            values[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getAnswer(N, N));
    }

    private static int getAnswer(int total, int pack) {
        if ( pack == 1)
            return values[pack] * total;
        if (dp[total][pack] > 0)
            return dp[total][pack];
        if (pack > total)
            return getAnswer(total, pack-1);
        dp[total][pack] = Math.max(getAnswer(total, pack -1), getAnswer(total - pack, pack) + values[pack]);
        return dp[total][pack];
    }
}
