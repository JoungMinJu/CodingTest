package Reis.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085 {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] map = new String[n][n];
        boolean[][] visited = new boolean[n][n];
        int nextX, nextY, nowX, nowY;
        int answer = -1;

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = tmp[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nowX = i;
                nowY = j;

                visited[nowX][nowY] = true;
                for (int k = 0; k < 4; k++) {
                    nextX = nowX + dx[k];
                    nextY = nowY + dy[k];
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                        answer = Math.max(answer, getAnswer(map, nowX, nowY, nextX, nextY));
                    }
                }
            }

        }
        System.out.println(answer);

    }

    private static int getAnswer(String[][] map, int nowX, int nowY, int nextX, int nextY) {
        int answer = -1;
        int count;
        String tmp = map[nowX][nowY];
        map[nowX][nowY] = map[nextX][nextY];
        map[nextX][nextY] = tmp;

        // 가로
        for (int i = 0; i < map.length; i++) {
            String before = map[i][0];
            count = 1;
            for (int j = 1; j < map[i].length; j++) {
                if(before.equals(map[i][j])) {
                    count++;
                }
                else {
                    answer = Math.max(answer, count);
                    before = map[i][j];
                    count = 1;
                }
            }
        }

        // 세로
        for(int j = 0; j<map[0].length; j++){
            String before = map[0][j];
            count = 1;
            for (int i  = 1; i<map.length; i++){
                if(before.equals(map[i][j])){
                    count ++;
                }
                else {
                    answer = Math.max(answer, count);
                    before = map[i][j];
                    count = 1;
                }
            }
        }
        return answer;
    }
}
