package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_1652_adv {
    public static void main(String[] args)  throws IOException {
        // 가로세로를 기준으로 반복문을 통해 장애물을 만나기 전까지 카운터를 증가시키고
        // 짐이나 벽을 만났을 때 카운터가 2 이상이면 누울자리라고 판단한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for(int i=0;i<N;i++){
            String[] s = br.readLine().split("");
            for(int j=0;j<N;j++){
                map[i][j]= s[j].charAt(0);
            }
        }

        int row = 0;
        int col =0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N-1;j++){
                row +=(map[i][j] =='.'&&map[i][j+1]=='.'&&map[i][j+2]=='X')?1:0;
                col +=(map[i][j]=='.'&&map[j+1][i]=='.'&&map[j+2][i]=='X')?1:0;
            }
        }
    }
}
