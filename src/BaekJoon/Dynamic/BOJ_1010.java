package BaekJoon.Dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int d[][];
        for(int test=0; test<t; test++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            // d[n][m] = n개의 사이트와 m개의 사이트를 잇는 모든 경우의 수
            d = new int[n+1][m+1];
            for(int i=0; i<=m; i++) d[1][i] = i;
            for(int i=2; i<=n;i++){
                for(int j=i; j<=m; j++){
                    for(int k=j; k>=i; k--)
                        d[i][j] += d[i-1][k-1];
                }
            }
            bw.write(String.valueOf(d[n][m]));
            bw.newLine();
        }
        bw.close();
        br.close();
    }

}
