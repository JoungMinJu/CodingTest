package Reis.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6593 {
    static char[][][] map;
    static boolean[][][] visited;
    static int[] dR = {0, 0, 0, 0, 1, -1};
    static int[] dC = {0, 0, 1, -1, 0, 0};
    static int[] dL = {1, -1, 0, 0, 0, 0};
    static int L, R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String input;
        int startLayer=0, startRow=0, startCol=0, answer = 0;

        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) {
                break;
            } // i면 j행 k열
            map = new char[L][R][C];
            visited = new boolean[L][R][C];

            // 입력 받기
            for (int layer = 0; layer < L; layer++) {
                for (int row = 0; row < R; row++) {
                    input = br.readLine();
                    for (int col = 0; col < C; col++) {
                        map[layer][row][col] = input.charAt(col);
                        if (map[layer][row][col] == 'S') {
                            startLayer = layer;
                            startRow = row;
                            startCol = col;
                        }
                    }
                }
                br.readLine();
            }

            answer = bfs(startLayer, startRow, startCol);
            if (answer == -1) {
                sb.append("Trapped!").append("\n");
            } else {
                sb.append(String.format("Escaped in %d minute(s).", answer)).append("\n");
            }
        }
        System.out.println(sb.toString().strip());
    }

    private static int bfs (int layer, int row, int col) {
        Queue<List<Integer>> que = new LinkedList<>();
        int count = 0;
        List<Integer> now;
        int nowLayer, nowRow,nowCol;
        int nextLayer, nextRow, nextCol, size = 0;

        visited[layer][row][col] = true;
        que.add(List.of(layer, row, col));

        while(!que.isEmpty()) {
            size = que.size();
            for (int turn =0; turn < size; turn++) {
                now = que.poll();
                nowLayer = now.get(0);
                nowRow = now.get(1);
                nowCol = now.get(2);
                if (map[nowLayer][nowRow][nowCol] == 'E') {
                    return count;
                }

                for (int i= 0; i<6; i++) {
                    nextLayer = nowLayer + dL[i];
                    nextRow = nowRow + dR[i];
                    nextCol = nowCol + dC[i];
                    if (nextLayer < 0 || nextLayer >= L || nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C) {
                        continue;
                    }
                    if (!visited[nextLayer][nextRow][nextCol] && (map[nextLayer][nextRow][nextCol] != '#' )) {
                        visited[nextLayer][nextRow][nextCol] = true;
                        que.add(List.of(nextLayer,nextRow,nextCol));
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
