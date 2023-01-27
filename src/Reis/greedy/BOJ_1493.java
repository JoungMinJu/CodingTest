package Reis.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1493 {
    public static int boxLength, boxWidth, boxHeight;
    public static int[] cubes = new int[20];
    public static boolean isSuccess;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boxLength = Integer.parseInt(st.nextToken());
        boxWidth = Integer.parseInt(st.nextToken());
        boxHeight = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cubes[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        solution(boxLength, boxWidth, boxHeight);

        if (isSuccess) {
            System.out.println(count);
        }
        else {
            System.out.println(-1);
        }
    }

    public static void solution(long l, long w, long h) {
        if (l == 0 || w == 0 || h == 0) {
            return;
        }

        isSuccess = false;
        long cubeLength = 0;

        for (int i = cubes.length-1; i >= 0; i--) {
            if (cubes[i] <= 0) {
                continue;
            }
            cubeLength = (long) Math.pow(2, i);
            if (l >= cubeLength && w >= cubeLength && h >= cubeLength) {
                count++;
                cubes[i]--;
                isSuccess = true;
                break;
            }
        }

        if (!isSuccess) {
            return;
        }
        solution(cubeLength, w - cubeLength, cubeLength);
        solution(l - cubeLength, w, cubeLength);
        solution(l, w, h - cubeLength);
    }
}
