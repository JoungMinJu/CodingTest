package study.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken()); // 게임 횟수
        long y = Integer.parseInt(st.nextToken()); // 이긴 게임
        long percent = y * 100 / x;
        long left = 1;
        long right = x;

        // 최소 횟수를 구하는 것이기 때문에 이분탐색 활용
        if(percent >=99) System.out.println(-1);
        else{
            long mid = 0, ratio = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                ratio = (y + mid) * 100 / (x + mid);

                if (ratio > percent) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(left);
        }
    }
}
