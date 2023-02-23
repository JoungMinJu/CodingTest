package Reis.twoPointer_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2096 {
    static int N;
    static int[] map;
    static int[] dpMax;
    static int[] dpMin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int x1, x2, x3;

        dpMax = new int[3];
        dpMin = new int[3];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            x3 = Integer.parseInt(st.nextToken());

            if (i == 0) { // 초깃값은 걍 넣기
                dpMax[0] = dpMin[0] = x1;
                dpMax[1] = dpMin[1] = x2;
                dpMax[2] = dpMin[2] = x3;
            } else {
                // 최댓값 구하기
                int beforeMaxDp0 = dpMax[0];
                int beforeMaxDp2 = dpMax[2];
                dpMax[0] = Math.max(dpMax[0], dpMax[1]) + x1;
                dpMax[2] = Math.max(dpMax[1], dpMax[2]) + x3;
                dpMax[1] = Math.max(Math.max(beforeMaxDp0, beforeMaxDp2), dpMax[1]) + x2;

                // 최솟값 구하기
                int beforeMinDp0 = dpMin[0];
                int beforeMinDp2 = dpMin[2];
                dpMin[0] = Math.min(dpMin[0], dpMin[1]) + x1;
                dpMin[2] = Math.min(dpMin[2], dpMin[1]) + x3;
                dpMin[1] = Math.min(Math.min(beforeMinDp0, beforeMinDp2), dpMin[1]) + x2;
            }
        }
        sb.append(Math.max(dpMax[0], Math.max(dpMax[1], dpMax[2])));
        sb.append(" ");
        sb.append(Math.min(dpMin[0], Math.min(dpMin[1], dpMin[2])));
        System.out.println(sb.toString());
    }
}
