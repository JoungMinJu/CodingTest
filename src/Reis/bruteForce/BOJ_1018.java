package Reis.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1018 {
    public static String order = "WB";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char map[][] = new char[n][m];
        int answer = 50 * 50 + 1;
        int tmp = 0;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                tmp = Math.min(getAnswer('W', map, i, j, i + 8, j + 8), getAnswer('B', map, i, j, i + 8, j + 8));
                answer = Math.min(answer, tmp);
            }
        }
        System.out.println(answer);
    }

    private static int getAnswer(char startChar, char[][] map, int startX, int startY, int endX, int endY) {
        int count = 0, index;
        List<List<Integer>> changeIndexes = new ArrayList<>();

        // 첫번쨰 열 맞추기
        index = order.indexOf(map[startX][startY]);
        if (startChar != map[startX][startY]) {
            map[startX][startY] = order.charAt((index += 1) % 2);
            count++;
            changeIndexes.add(List.of(startX, startY));
        }

        for (int i = startX + 1; i < endX; i++) {
            if (order.charAt((index + 1) % 2) != map[i][startY]) {
                count++;
                changeIndexes.add(List.of(i, startY));
                map[i][startY] = order.charAt((index + 1) % 2);
            }
            index++;
        }

        // 나머지 열 맞추기
        for (int i = startX; i < endX; i++) {
            index = order.indexOf(map[i][startY]);
            for (int j = startY + 1; j < endY; j++) {
                if (order.charAt((index + 1) % 2) != map[i][j]) {
                    count++;
                    changeIndexes.add(List.of(i, j));
                    map[i][j] = order.charAt((index + 1) % 2);
                }
                index++;
            }
        }

        for (List<Integer> changeIndex : changeIndexes) {
            int nowX = changeIndex.get(0);
            int nowY = changeIndex.get(1);
            index = order.indexOf(map[nowX][nowY]);
            map[nowX][nowY] = order.charAt((index + 1) % 2);
        }
        return count;
    }

}
