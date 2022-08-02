package study.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] min = new int[n][3];
        int[][] max = new int[n][3];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(i==0) {
                    min[i][j] = tmp;
                    max[i][j] = tmp;
                }
                else if(j==0) {
                    min[i][j] = Math.min(min[i-1][j], min[i-1][j+1]) + tmp;
                    max[i][j] = Math.max(max[i-1][j], max[i-1][j+1]) + tmp;
                }
                else if(j==2) {
                    min[i][j] = Math.min(min[i-1][j], min[i-1][j-1]) + tmp;
                    max[i][j] = Math.max(max[i-1][j], max[i-1][j-1]) + tmp;
                }
                else {
                    min[i][j] = Math.min(Math.min(min[i-1][j], min[i-1][j+1]), min[i-1][j-1]) + tmp;
                    max[i][j] = Math.max(Math.max(max[i-1][j], max[i-1][j+1]), max[i-1][j-1]) + tmp;
                }
            }
        }
        sb.append(Math.max(Math.max(max[n-1][2], max[n-1][1]),max[n-1][0])).append(" ").append(Math.min(Math.min(min[n-1][2], min[n-1][1]),min[n-1][0]));
        System.out.println(sb.toString());
    }
}
