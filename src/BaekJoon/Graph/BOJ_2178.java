package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    // 최단거리 => BFS
    static int count;
    static int map[][];
    static boolean visited[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        // 입력 완료
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0; i<n;i++){
            String temp = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = temp.charAt(j)-'0';
            }
        }
        // 큐에 시작점 넣기.
        visited = new boolean[n][m];
        bfs();
        System.out.println(map[n-1][m-1]);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while(!q.isEmpty()){
            int [] now = q.poll();
            for(int i=0;i<4;i++){
                int newX = now[0] + dx[i];
                int newY = now[1] +dy[i];
                if(newX >= 0 && newX < n && newY >= 0 && newY < m){
                    if(!visited[newX][newY] && map[newX][newY] == 1){
                        q.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                        map[newX][newY] = map[now[0]][now[1]] +1;
                    }
                }
            }
        }
    }


}
