package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1049 {
    // N개의 줄이 끊어짐.
    // 6줄 패키지 or 1개 또는 그 이상의 줄
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        // n개의 줄이 끊어짐
        int n = Integer.parseInt(st.nextToken());
        // 기타줄 브랜드 m개
        int m = Integer.parseInt(st.nextToken());
        int result= 0;
        // 패키지
        int[] pack = new int[m];
        int[] single = new int[m];
        for(int i=0;i<m;i++){
            // 패키지가격 낱개가격
            st = new StringTokenizer(br.readLine());
            pack[i] = Integer.parseInt(st.nextToken());
            single[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pack);
        Arrays.sort(single);

        int minPack = pack[0];
        int minSingle = single[0];

        int ansSingle = minSingle * n;
        int ansPack = 0;
        int ansMix =Integer.MAX_VALUE;
        if (n % 6 == 0) {
            ansPack = minPack * (n/6);
        }
        else{
            ansPack = minPack * (n/6+1);
            ansMix = minPack * (n/6) + minSingle * (n%6);
        }

        System.out.println(Math.min(ansPack, Math.min(ansSingle, ansMix)));

    }
}
