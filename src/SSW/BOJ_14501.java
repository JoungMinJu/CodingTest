package SSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {
    public static void main(String[] args) throws IOException {
        // 거꾸로 생각하기!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] T = new int[n+1];
        int[] P = new int[n+1];
        int[] dp = new int[n+2];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 최대 비용
        // -> 퇴사 전에 삳담할 수 있어야함
        for(int i=n; i>0; i--){
            int time = i + T[i];
            if(time > n+1){
                dp[i] = dp[i+1];
            }
            else{
                dp[i] = Math.max(dp[i+1], dp[time] + P[i]); //선택을 안하든가, 하든가
            }
        }
        System.out.println(dp[1]);
    }
}
