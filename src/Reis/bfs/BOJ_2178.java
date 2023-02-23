package Reis.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static int N, M;
    static int[] dR = {0, 0, -1, 1};
    static int[] dC = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String input;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int row = 0; row < N; row++) {
            input = br.readLine();
            for (int col = 0; col < M; col++) {
                map[row][col] = input.charAt(col) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int result = 1;
        int size, nowRow, nowCol, nextRow, nextCol;
        List<Integer> now;

        Queue<List<Integer>> que = new LinkedList<>();
        que.add(List.of(0, 0));

        while (!que.isEmpty()) {
            size = que.size();
            now = que.poll();
            nowRow = now.get(0);
            nowCol = now.get(1);
            visited[nowRow][nowCol] = true;
            if (nowRow == N - 1 && nowCol == M - 1)
                return map[nowRow][nowCol];
            for (int idx = 0; idx < 4; idx++) {
                nextRow = nowRow + dR[idx];
                nextCol = nowCol + dC[idx];
                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) {
                    continue;
                }
                if (map[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                    que.offer(List.of(nextRow, nextCol));
                    map[nextRow][nextCol] = map[nowRow][nowCol] + 1;
                }
            }
        }
        return map[N - 1][M - 1];

    }
}

