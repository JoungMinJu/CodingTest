package Reis.divideAndConuer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1725 {
    public static int N; // 가로 칸의 수
    public static int[] heights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        heights = new int[N];

        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(getAnswer(0, N));
    }

    private static int getAnswer(int start, int end) {
        if (start == end) {
            return 0;
        }
        if (start + 1 == end) {
            return heights[start];
        }

        int mid = (start + end) / 2;
        int result = Math.max(getAnswer(start, mid), getAnswer(mid, end));

        int width = 1, height = heights[mid], left = mid, right = mid;
        int p, q;

        while (right - left + 1 < end - start) {
            // 왼쪽으로 확장시 높이
            if (left > start) {
                p = Math.min(height, heights[left - 1]);
            } else {
                p = -1;
            }
            // 오른쪽으로 확장시 높이
            if (right < end - 1) {
                q = Math.min(height, heights[right + 1]);
            } else {
                q = -1;
            }

            // 더 높은 높이를 가진 쪽으로 확장
            if (p >= q) {
                height = p;
                left--;
            } else {
                height = q;
                right++;
            }
            result = Math.max(result, ++width*height);
        }
        return result;
    }
}
