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
        for(int i=0;i<n;i++){
            String temp = br.readLine();
            for(int j=0;j<temp.length();j++){
                map[i][j] = temp.charAt(j);
            }
        }

        // BFS 시작
        q.offer(new int[]{0,0});
        check[0][0] = true;
        // 첫번쨰 ans
        ans_one = 1;
        while(!q.isEmpty()){
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            char char_check = map[x][y];
            for(int i=0;i<4;i++){
                bfs(i, x,y, char_check);
            }
        }



    }

    private static void bfs(int i, int x, int y, char char_check) {
        int nextX = x + movedX[i];
        int nextY = x + movedY[i];
        if(nextX >= 0 && nextX <n && nextY >=0 && nextY < n){
            if(!check[nextX][nextY]){
                // 체크가 안되어있는데 같은 영역이면
                if(char_check == map[nextX][nextY]){
                    check[nextX][nextY] = true;
                    q.offer(new int[]{nextX, nextY});
                }
                // 체크가 안되어있는데 다른 영역이면
                if(char_check != map[nextX][nextY]){
                    char_check = map[nextX][nextY];
                    ans_one++;
                    check[nextX][nextY] = true;
                    q.offer(new int[]{nextX, nextY});
                }
            }
        }
    }
}
