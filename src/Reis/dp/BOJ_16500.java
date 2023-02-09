package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BOJ_16500 {
    // 모르겠음 . .
    static int N;
    static String S;
    static int[] dp;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        N = Integer.parseInt(br.readLine());

        dp = new int[S.length() + 1];

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = S.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < S.length(); j++) {
                if (dp[j] == 1) {
                    if (set.contains(S.substring(i, j))) {
                        dp[i] = 1;
                        break;
                    }
                }
            }
            if (set.contains(S.substring(i))) {
                dp[i] = 1;
            }
        }

        System.out.println(dp[0]);
    }



}
