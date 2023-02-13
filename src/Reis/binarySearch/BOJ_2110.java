package Reis.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
    public static int C; // 설치할 공유기 개수
    public static int N;
    public static int[] homes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());


        homes = new int[N];

        for (int i = 0; i<N; i++){
            homes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homes);

        long left = 1;
        long right = homes[N-1] - homes[0];

        while (left <= right) {
            long mid = (left + right) / 2;
            int count = getCount(mid);

            if (count >= C) {
                left = mid + 1;
            }
            else {
                right = mid -1;
            }
        }

        System.out.println(right);
    }

    private static int getCount(long mid) {
        int count = 1;
        int before = homes[0];

        for (int i = 1; i<N; i++){
            if (homes[i] - before >= mid) {
                count++;
                before = homes[i];
            }
        }

        return count;
    }
}
