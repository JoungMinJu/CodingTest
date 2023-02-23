package Reis.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1743 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dR = { 0,0, -1, 1};
    static int[] dC = { 1, -1, 0,0};
    static int count, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0, r, c;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map[r - 1][c - 1] = 1;
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (map[row][col] == 1 && !visited[row][col]) {
                    count = 0;
                    dfs(row, col);
                    answer = Math.max(count, answer);
                }
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int row, int col) {
        int nextRow, nextCol;
        visited[row][col] = true;
        count++;

        for (int i = 0; i<4; i++) {
            nextRow = row + dR[i];
            nextCol = col + dC[i];
            if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M ) {
                continue;
            }
            if (map[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                dfs(nextRow, nextCol);
            }
        }
    }
}
