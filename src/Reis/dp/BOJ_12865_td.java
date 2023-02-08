package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_td {
    public static Integer[][] dp;
    public static Item[] items;

    public static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new Integer[N][K+1];
        items = new Item[N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.println(getAnswer(N-1, K));
    }

    private static int getAnswer(int itemIdx, int weight) {
        if (itemIdx < 0)
            return 0;
        if (dp[itemIdx][weight] == null ) {
            if (items[itemIdx].weight > weight) {
                dp[itemIdx][weight] = getAnswer(itemIdx-1, weight);
            }
            else {
                dp[itemIdx][weight] = Math.max(getAnswer(itemIdx-1, weight), getAnswer(itemIdx -1, weight - items[itemIdx].weight) + items[itemIdx].value);
            }
        }
        return dp[itemIdx][weight];
    }
}
