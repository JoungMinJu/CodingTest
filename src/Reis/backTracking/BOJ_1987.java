package Reis.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {
    static int[] dR = {0, 0, -1, 1};
    static int[] dC = {1, -1, 0, 0};
    static char[][] map;
    static boolean[][] visited;
    static boolean[] used = new boolean[26];
    static int R, C, result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String input;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int row = 0; row < R; row++) {
            input = br.readLine();
            for (int col = 0; col < C; col++) {
                map[row][col] = input.charAt(col);
            }
        }


    }

    private void backtracking(int row, int col, int dist) {
        int nextRow, nextCol;
        result = Math.max(result, dist);
        visited[row][col] = true;
        used[map[row][col]-'A'] = true; // 지금 알파벳 썼다고 체크

        for (int idx = 0; idx < 4; idx++) {
            nextRow = row + dR[idx];
            nextCol = col + dC[idx];
            if (nextRow < 0 || nextRow >=R || nextCol < 0 || nextCol >= C)
                continue;
            if (!visited[nextRow][nextCol] && !used[map[nextRow][nextCol]-'A']) {
                backtracking(nextRow, nextCol, dist + 1);
            }
        }
        // 방문 전의 상태로 돌려놓기-> 지금 내 A가 아니라 다른 A를 사용 할 수도 있는거니까
        visited[row][col] = false;
        used[map[row][col]-'A'] = false;
    }
}
