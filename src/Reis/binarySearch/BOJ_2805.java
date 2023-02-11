package Reis.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {
    public static int N;
    public static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 나무 M 미터가 필요. -> 절단기 높이 H 지정하기.

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long maxLen = Integer.MIN_VALUE;
        long minLen = 0;

        trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i= 0; i<N; i++){
            trees[i]= Integer.parseInt(st.nextToken());
            if (trees[i] > maxLen) {
                maxLen = trees[i];
            }
        }

        while (minLen <= maxLen ) {
            long midLen = (minLen + maxLen)/2;
            long treeLen = getTreeLen(midLen);

            if (treeLen >= M ) {
                minLen = midLen + 1;
            }
            else {
                maxLen = midLen -1;
            }
        }
        System.out.println(maxLen);

    }

    private static long getTreeLen(long len) {
        long answer = 0;
        for (int tree : trees) {
            if (tree > len )
                answer += (tree - len);
        }
        return answer;
    }
}
