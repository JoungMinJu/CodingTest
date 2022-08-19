package study.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int div = 10007;

        int[][] tr = new int[n+1][n+1];

        for(int i=0; i<tr.length; i++){
            for(int j=0; j<=i; j++){
                if(i==j || j==0) tr[i][j] =1;
                else
                    tr[i][j] = (tr[i-1][j-1] + tr[i-1][j]) % div;
            }
        }
        System.out.println(tr[n][k]);
    }
}

