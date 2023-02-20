package Reis.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3190 {
    public static int[][] map;
    public static int[] dR = {0, 1, 0, -1};
    public static int[] dC = {1, 0, -1, 0};
    public static Queue<List<Integer>> snake = new LinkedList<>();
    public static int nowRow, nowCol, count, directionIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 보드의 크기
        int K = Integer.parseInt(br.readLine()); // 사과의 개수


        // 0  -> 아무것도 없다 1 -> 뱀이 있다 2 -> 사과가 있다.
        map = new int[N][N];
        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 2;
        }

        // 뱀 위치 초기화
        nowRow = 0;
        nowCol = 0;
        directionIndex = 0;
        map[nowRow][nowCol] = 1;
        snake.add(List.of(nowRow, nowCol));

        int L = Integer.parseInt(br.readLine()); // 방향 변환 횟수
        int time;
        char direction;
        boolean isSuccess = true;
        count = 1;

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            time = Integer.parseInt(st.nextToken());
            direction= st.nextToken().charAt(0);
            isSuccess = moveAndReturnIsSuccessOrNot(time, direction);
            if (!isSuccess) {
                System.out.println(count);
                break;
            }
        }
        if(isSuccess) {
            moveAndReturnIsSuccessOrNot(Integer.MAX_VALUE, 'X');
            System.out.println(count);
        }
    }

    private static boolean moveAndReturnIsSuccessOrNot(int time, char direction) {
        for (; count <= time; count++) {
            nowRow += dR[directionIndex];
            nowCol += dC[directionIndex];
            if (nowRow < 0 || nowRow >= map.length || nowCol < 0 || nowCol >= map.length )
                return false;
            if (map[nowRow][nowCol] == 1)
                return false;
            move();
        }
        if (direction == 'L') {
            directionIndex--;
            if (directionIndex < 0)
                directionIndex += dR.length;
        }
        else if (direction == 'D') {
            directionIndex = (directionIndex + 1) % dR.length;
        }
        return true;
    }

    private static void move() {
        snake.add(List.of(nowRow, nowCol));
        if (map[nowRow][nowCol] != 2){
            List<Integer> tailPos = snake.poll();
            map[tailPos.get(0)][tailPos.get(1)] = 0;
        }
        map[nowRow][nowCol] = 1;
    }
}
