package Reis.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2667 {
    public static int N, answer = 0;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dR = {0, 0, 1, -1};
    public static int[] dC = {1, -1, 0, 0};
    public static List<Integer> lst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        lst = new ArrayList<>();
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int row = 0; row < N; row++ ) {
            input = br.readLine();
            for (int col = 0; col < N; col++){
                map[row][col] = input.charAt(col) - '0';
            }
        }

        for (int row = 0; row < N; row++){
            for (int col = 0; col < N; col++) {
                if (map[row][col] == 1 && !visited[row][col]) {
                    answer = 0;
                    dfs(row, col);
                    lst.add(answer);
                }
            }
        }
        sb.append(lst.size()).append("\n");

        Collections.sort(lst);

        for (int i =0; i<lst.size(); i++){
            sb.append(lst.get(i)).append("\n");
        }
        System.out.println(sb.toString().strip());
    }

    private static void dfs(int row, int col) {
        int nextRow, nextCol;
        answer++;
        visited[row][col] = true;
        for (int idx = 0; idx < 4; idx++ ) {
            nextRow = row + dR[idx];
            nextCol = col + dC[idx];
            if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N ) {
                continue;
            }
            if (map[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                dfs(nextRow, nextCol);
            }
        }
    }

}
