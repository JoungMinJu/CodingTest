package study.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1149_adv {


    static class House{
        HashMap<String, Integer> map;
        public House(){
            this.map = new HashMap<>();
        }
        public void put_map(String key, int value){
            this.map.put(key, value);
        }
        public int get_price(String key){
            return this.map.get(key);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int dp[][] = new int[n][3];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<n;i++){
            dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]);
        }
        System.out.println(Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]));
    }
}
