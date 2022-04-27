package Algorithm_Two.CH9.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int value[] = new int[n];
        int answer = 0;
        for(int i=0;i<n;i++){
            value[i] = Integer.parseInt(br.readLine());
        }
        for(int i=n-1;i>=0;i--){
            if(value[i] <= k ){
                answer += k / value[i];
                k %= value[i];
            }
            if(k==0) break;
        }
        System.out.println(answer);
    }
}
