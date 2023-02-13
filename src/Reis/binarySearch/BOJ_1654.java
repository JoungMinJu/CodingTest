package Reis.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654 {
    public static int N;
    public static int[] lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선 개수
        N = Integer.parseInt(st.nextToken()); // 만드록자하는 랜선의 개수

        lines = new int[K];

        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lines);

        long left = 1, right = lines[lines.length - 1];

        while (left <= right) {
            long mid = (left + right) / 2;
            int count = getCount(mid);

            if (count >= N) {
                left = mid + 1;
            }
            else {
                right = mid -1;
            }
        }
        System.out.println(right);
    }

    private static int getCount(long mid) {
        int count = 0;
        for (int line : lines) {
            count += (line / mid);
        }
        return count;
    }
}
