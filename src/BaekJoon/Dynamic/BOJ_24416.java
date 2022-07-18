package BaekJoon.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_24416 {
    static int count_recall =0;
    static int count_dp = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        recallFibo(n);
        dpFibo(n);
        sb.append(count_recall).append(" ").append(count_dp);
        System.out.println(sb);
    }
    public static int recallFibo(int n){
        System.out.println("n = " + n);
        count_recall++;
        System.out.println("count_recall = " + count_recall);
        if(n==1 || n ==2)
            return 1;
        return recallFibo(n-1)+recallFibo(n-2);
    }
    public static int dpFibo(int n){
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = dp[2] = 1;
        for(int i=3; i<=n; i++){
            count_dp++;
            dp[i] = dp[i-1]+dp[i-2];}
        return dp[n];
    }
}
