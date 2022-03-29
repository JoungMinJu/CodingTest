package BaekJoon.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4936 {
    // 가로 세로 대각선
    public static int dx[] = {1,-1,0,0, 1, 1,-1,-1};
    public static int dy[] = {0, 0, 1,-1,1,-1,1,-1};
    public static int w;
    public static int h;
    public static int map[][];
    public static boolean check[][];
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 너비
        while(true) {
            st= new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            // 조건문
            if(w==0 && h==0) break;
            // 초기화
            map = new int[w][h];
            check = new boolean[w][h];
            // 넣기 --> 0 0  두개 주어지기 전까지는 계속해서 testcase
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            answer = 0;
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (!check[i][j] && map[i][j]==1) {
                        dfs(i, j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }

   }

    private static void dfs(int i, int j) {
        check[i][j] = true;
        for(int k=0;k<8;k++){
            int newX = i+dx[k];
            int newY = j+dy[k];
            if(newX >=0 && newX<w && newY>=0 && newY<h){
                if(!check[newX][newY] && map[newX][newY] == 1){
                    dfs(newX, newY);
                }
            }
        }
    }
}
