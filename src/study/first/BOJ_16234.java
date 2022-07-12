package study.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int map[][];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // NxN 크기의 땅
        int l = Integer.parseInt(st.nextToken()); // 인구이동조건 하한
        int r = Integer.parseInt(st.nextToken()); // 인구이동조건 상한
        map = new int[n][n];
        visited = new boolean[n][n];

        // 입력
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // bfs

    }

    static void bfs(int[] start){
        Queue<int []> q = new LinkedList<>();
        q.offer(start);
        // 시작할 x축 y축 넣어주기
        q.offer(start);
        // 시작 노드 방문 처리
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){

            }
        }
    }
}
