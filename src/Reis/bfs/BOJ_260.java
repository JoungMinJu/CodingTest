package Reis.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_260 {
    static int N, M;
    static int[][] map;
    static boolean[] visited;
    static StringBuilder dfsSB = new StringBuilder();
    static StringBuilder bfsSB = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int start, end;

        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            map[start][end] = 1;
            map[end][start] = 1;
        }

        dfs(V);
        sb.append(dfsSB.toString()).append("\n");

        Arrays.fill(visited, false);
        bfs(V);
        sb.append(bfsSB.toString());

        System.out.println(sb.toString().trim());
    }

    private static void dfs(int root) {
        visited[root] = true;
        dfsSB.append(root).append(" ");;
        for (int col = 1; col <= N; col++){
            if (!visited[col] && map[root][col] == 1 ){
                dfs(col);
            }
        }
    }

    private static void bfs(int root) {
        Queue<Integer> que = new LinkedList<>();
        visited[root]=true;
        que.offer(root);
        int now;

        while (!que.isEmpty()) {
            now = que.poll();
            bfsSB.append(now).append(" ");
            for (int col = 1; col <= N; col++){
                if (!visited[col] && map[now][col] ==1 ) {
                    que.offer(col);
                    visited[col] = true;
                }
            }
        }

    }
}
