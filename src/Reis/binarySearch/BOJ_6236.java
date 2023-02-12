package Reis.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6236 {
    public static int M, low, high;
    public static int[] needMoney;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        needMoney = new int[N];
        low = 0;
        high = 0;
        int answer = 0;

        for (int i= 0; i<N; i++){
            needMoney[i] = Integer.parseInt(br.readLine());
            high += needMoney[i];
            low = Math.max(low, needMoney[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int count = getCount(mid);

            if (count > M ) {
                low = mid + 1;
            }
            else {
                answer = mid;
                high = mid -1;
            }
        }

        System.out.println(answer);
    }

    private static int getCount(int mid) {
        int remain = mid;
        int cnt = 1;
        for (int money : needMoney) {
            if (remain - money < 0){
                remain = mid;
                cnt++;
            }
            remain -= money;
        }
        return cnt;
    }

}
