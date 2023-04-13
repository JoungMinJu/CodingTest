package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class Item {
    static int[][] map = new int[21][21];
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, 1, -1};

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) {
        int[][] input = new int[][]{{1,1,7,4},
                                    {3,2,5,4},
                                    {4,3,6,9},
                                    {2,6,8,8}};
        int answer = solution(input, 1, 3, 7,8);
        System.out.println(answer);
    }

    private static int solution(int[][] rectangle, int startCol, int startRow, int endCol, int endRow) {
        for(int[] rec : rectangle) {
            fill(rec);
        }
        for (int row = 0; row < map.length; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < map[0].length; col++) {
                if(row == 0) {
                    System.out.print(col + " ");
                }
                System.out.print(map[row][col] + " ");
            }
            System.out.println();
        }
        bfs(new Point(2 * startRow, 2 * startCol), new Point(2 * endRow, 2 * endCol));
        System.out.println("" );
        System.out.println();
        System.out.println(
        );
        for (int row = 0; row < map.length; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < map[0].length; col++) {
                if(row == 0) {
                    System.out.print(col + " ");
                }
                System.out.print(map[row][col] + " ");
            }
            System.out.println();
        }
        int answer = map[2*startRow][2*startCol] / 2;
        return answer;
    }

    private static void fill(int[] coords) {
        int col1 = 2 * coords[0];
        int row1= 2 * coords[1];
        int col2 = 2 * coords[2];
        int row2 = 2 * coords[3];

        // x축 채우기
        for (int colGap = 0; colGap < (col2 - col1); colGap++) {
            int col = col1 + colGap;

            map[row1][col] = (map[row1][col] == 0) ? 1 : map[row1][col];
            map[row2][col] = (map[row2][col]  == 0) ? 1 : map[row2][col];
            // 내부는 2로 채우기
            if (col != col1 && col != col2 ) {
                for (int row = row1+1; row < row2; row++) {
                    map[row][col] = 2;
                }
            }
        }
        //y축 채우기
        for(int rowGap = 0; rowGap < (row2-row1); rowGap++) {
            int row = row1 + rowGap;
            map[row][col1] = (map[row][col1] == 0) ? 1 :map[row][col1];
            map[row][col2] = (map[row][col2] == 0) ? 1 : map[row][col2];
        }
    }

    private static void bfs (Point startPoint, Point endPoint) {
        Point now;
        int nextRow, nextCol;
        Queue<Point> que = new LinkedList<>();
        que.add(startPoint);
        // 방문처리는 0으로 바꾸면서 하는거지
        map[startPoint.row][startPoint.col] = 0;

        while (!que.isEmpty()) {
            now = que.poll();
            // 상하좌우
            for (int idx = 0; idx < 4; idx++) {
                nextRow = now.row + dR[idx];
                nextCol = now.col + dC[idx];

                if (nextRow < 0 || nextRow >= 101 || nextCol < 0 || nextCol >= 101) {
                    continue;
                }
                if (map[nextRow][nextCol] == 1) {
                    map[nextRow][nextCol] = map[now.row][now.col] + 1;
                    que.add(new Point(nextRow, nextCol));
                    if (nextRow == endPoint.row && nextCol == endPoint.col) {
                        System.out.println(map.toString());
                        return;
                    }
                }
            }
        }
    }
}
