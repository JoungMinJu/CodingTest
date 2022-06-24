package Programmers.SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CH2 {
    static int map[][];
    static int n, m, r, k;
    static int success_ex; // 다 모았는지 확인위한 변수
    static boolean[][] visited;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // ABC를 모아서 왕궁으로 가서 새로운 왕이 되고 싶다.
        // 이때 산이 위치한 곳은 원래 x인데 엑스칼리버 있으면 지나갈 수 있음.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int test=0; test<t; test++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];
            success_ex = 0;
            // 입력
            for(int i=0; i<n;i++){
                String input = br.readLine();
                for(int j=0;j<m;j++){
                    char tmp = input.charAt(j);
                    if(tmp == '.') map[i][j] = 1;
                    else if(tmp == 'X') map[i][j] = 0;
                    else if(tmp == 'A' || tmp == 'B' || tmp == 'C') map[i][j] = -1;
                    else if(tmp == 'S') map[i][j] = -2;
                }
            }
            bfs();
        }

    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,k});

        while(!q.isEmpty()){
            int [] now = q.poll();
            for(int i=0;i<4;i++){
                int newX = now[0] + dx[i];
                int newY = now[1] +dy[i];
                if(newX >= 0 && newX < n && newY >= 0 && newY < m){
                    if(!visited[newX][newY] && (map[newX][newY] > 0 || map[newX][newY] == -1)){
                        // 엑칼이라면 (체크)
                        q.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                        map[newX][newY] = map[now[0]][now[1]] +1;
                    }
                    // 엑칼 다 모았는지 확인하는 과정 필요
                }
            }
        }
    }
}
