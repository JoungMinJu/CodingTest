package Reis.divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2247 {
    public static int N;
    public static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        makeStar(0, 0, N, false);

        for (int i = 0; i < N; i++){
            for (int j = 0; j<N; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void makeStar(int x, int y, int len, boolean isBlank) {
        if (isBlank) {
            for (int i = x; i < x + len; i++) {
                for (int j = y; j < y + len; j++) {
                    map[i][j] = ' ';
                }
            }
            return;
        }

        // len이 1인 블록일 때 -> 쪼갤 수 없을 때
        if (len == 1) {
            map[x][y] = '*';
            return;
        }

        int newLen = len / 3;
        int count = 0;

        for (int i = x; i < x + len; i += newLen) {
            for (int j = y; j < y + len; j += newLen) {
                count++;
                if (count == 5) {
                    makeStar(i, j, newLen, true);
                }
                else {
                    makeStar(i, j, newLen, false);
                }
            }
        }
    }
}
