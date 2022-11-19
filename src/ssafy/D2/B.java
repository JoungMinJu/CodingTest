package ssafy.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int n, x, y, moveIdx;
        int[][] map;

        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};

        for(int testCase = 1; testCase <=t; testCase++){
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            x=0;
            y=0;
            moveIdx = 0;

            for(int i=1; i<= n*n; i++){
                map[y][x] = i;
                x += dx[moveIdx];
                y += dy[moveIdx];

                if( x >=n || y >= n || x <0 || y<0){
                    x -= dx[moveIdx];
                    y -= dy[moveIdx];
                    moveIdx = (moveIdx + 1) % 4;
                    x += dx[moveIdx];
                    y += dy[moveIdx];
                }
                else if(map[y][x] != 0){
                    x -= dx[moveIdx];
                    y -= dy[moveIdx];
                    moveIdx = (moveIdx + 1) % 4;
                    x += dx[moveIdx];
                    y += dy[moveIdx];
                }
            }
            sb.append("#").append(testCase).append("\n");

            for(int i=0; i<map.length; i++){
                for(int j=0; j<map[i].length; j++){
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());

    }
}
