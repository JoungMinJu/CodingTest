package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for(int i=0;i<n;i++){
           String s= br.readLine();
           for(int j=0;j<m;j++){
               map[i][j] = s.charAt(j) -'0';
           }
        }


        int ansArea = 1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int check = map[i][j];
                int count = 0;
                for(int k=j+1;k<m;k++){
                    count++;
                    if(check == map[i][k]) {
                        break;}}
                if ((i+count)<n && (j+count)<m){
                    if(map[i+count][j+count] == map[i+count][j]&& map[i+count][j]==check){
                        ansArea = ansArea>(count+1)*(count+1)?ansArea:(count+1)*(count+1);
                    }}
                count=0;
            }
        }
        System.out.println(ansArea);
    }
}
