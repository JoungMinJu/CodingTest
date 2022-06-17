package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] map = new boolean[n+1];
        int answer = 0;
        for(int i=2; i<=n; i++){
            for(int j=i; j<=n; j+=i){
                if(!map[j]) {
                    answer ++;
                    map[j] = true;
                }
                if(answer==k){
                    System.out.println(j);
                    // 아예 끝내기 위한
                    System.exit(0);
                }
            }
        }
    }
}
