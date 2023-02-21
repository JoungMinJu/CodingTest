package Reis.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 내가 한거 -> 재귀함수 이용
public class BOJ_1012 {
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dR = {-1, 1, 0, 0};
    public static int[] dC = {0, 0, 1, -1};
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 상하좌우 인접
        int K, answer = 0, inputRow, inputCol;

        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            answer = 0;

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int k = 0; k < K; k++){
                st = new StringTokenizer(br.readLine());
                inputCol = Integer.parseInt(st.nextToken());
                inputRow = Integer.parseInt(st.nextToken());
                map[inputRow][inputCol] = 1;
            }

            for (int row = 0; row < N; row ++) {
                for (int col = 0; col < M; col++) {
                    if (map[row][col] == 1 && !visited[row][col]) {
                        bfs(row, col);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private static void bfs(int row, int col) {
        visited[row][col] = true;

        int nextRow, nextCol;
        for (int i = 0; i < 4; i++) {
            nextRow = row + dR[i];
            nextCol = col + dC[i];
            if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M ) {
                continue;
            }
            if (map[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                bfs(nextRow, nextCol);
            }
        }
    }
}
