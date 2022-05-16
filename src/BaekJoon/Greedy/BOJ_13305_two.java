package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13305_two {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 1km -> 1리터의 기름
        // 각 도시에 단 하나의 주유소. 주유소의 리터당 가격 다름
        // 도시의 개수
        int n = Integer.parseInt(br.readLine());
        // 도시 배열
        // 도로의 길이
        st = new StringTokenizer(br.readLine());
        long[] road = new long[n];
        for(int i=0;i<n;i++){
            if(i == n-1) road[i] = 0;
            else road[i] = Long.parseLong(st.nextToken());
        }
        // 주유소 가격
        st = new StringTokenizer(br.readLine());
        long[] oil = new long[n];
        for(int i=0;i<n;i++){
            oil[i] = Long.parseLong(st.nextToken());
             }


        // 계산
        long oil_price = Integer.MAX_VALUE;
        long answer = 0;
        for(int i=0;i<n;i++){
            oil_price = oil_price > oil[i] ? oil[i] : oil_price;
            answer += oil_price*road[i];
        }
        System.out.println(answer);
    }
}
