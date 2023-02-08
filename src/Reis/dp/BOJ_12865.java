package Reis.dp;

import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {
    public static class Item {
        private int weight;
        private int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public int getWeight() {
            return weight;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        int[][] dp = new int[N][K + 1];
        Item[] items = new Item[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 초기화
        for (int weight = 0; weight <= K; weight++) {
            if (weight >= items[0].getWeight())
                dp[0][weight] = items[0].getValue();
        }

        for (int itemIdx = 1; itemIdx < N; itemIdx++) {
            for (int weight = 0; weight <= K; weight++) {
                if (weight >= items[itemIdx].getWeight()) {
                    dp[itemIdx][weight] = Math.max(dp[itemIdx-1][weight - items[itemIdx].getWeight()] + items[itemIdx].getValue(), dp[itemIdx-1][weight]);
                }
                else {
                    dp[itemIdx][weight] = dp[itemIdx-1][weight];
                }
            }
        }

        System.out.println(dp[N-1][K]);

    }
}
