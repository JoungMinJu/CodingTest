package BaekJoon.Binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_16401 {
    static int[] snack;
    static int result, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        // 과자 n개의 길이
        snack = new int[n];
        for(int i=0;i<n;i++){
            snack[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(snack);

        binarySearch(1, snack[n-1]);
        System.out.println(result);
    }

    public static void binarySearch(int left, int right){
        if (left > right) return;
        int mid = (left+right)/2;
        int count = 0;

        for (int i : snack) {
            count += i/mid;
        }
        if(count >= m) {
            if(result < mid) result = mid;
            binarySearch(mid+1, right);
        }
        else{
            binarySearch(left, mid-1);
        }
    }


}
