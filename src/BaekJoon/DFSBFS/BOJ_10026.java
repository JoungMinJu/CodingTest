package BaekJoon.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 아직 하는 중

public class BOJ_10026 {
    static char[][] map;
    // 0이면 아직 방문 안함
    // 1이면 B
    // 2이면 R(or G)
    // 3이면 G
    static boolean check[][];
    // 상하좌우
    static int movedX[] = {0,0,1,-1 };
    static int movedY[] = {1,-1,0,0};
    // 적록색약은 R과 G를 구분하지 못한다.
    // 적록 색약이 아닌 사람이 봤을 떄의 구역의 개수와
    // 적록 색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해서 출력.
    static Queue<int[]> q = new LinkedList<>();
    static int ans_one;
    static int ans_two;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for(int i=0;i<n;i++){
            String temp = br.readLine();
            for(int j=0;j<n;j++){
                map[i][j] = temp.charAt(j);
            }
        }
        check = new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!check[i][j]){
                    dfs(i,j);
                    ans_one++;
                }
            }
        }
        check = new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j] =='G'){
                    map[i][j] = 'R';
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!check[i][j]){
                    dfs(i,j);
                    ans_two++;
                }
            }
        }
        System.out.println(ans_one+" "+ans_two);


    }

    private static void dfs(int x, int y) {
        check[x][y] = true;
        char c = map[x][y];
        for(int i=0;i<4;i++){
            int newX = x+movedX[i];
            int newY = y+movedY[i];
            if(newX >=0 && newX<n&& newY >=0 && newY<n){
                if (!check[newX][newY] && map[newX][newY]==c) {
                    dfs(newX, newY);
                }
            }
        }
    }


}
