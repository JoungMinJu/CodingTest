package study.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] top = new int[h+1]; // 종유석
        int[] bottom = new int[h+1]; // 석순

        int min = n; // 파괴하는 장애물 최솟값
        int cnt = 0; // 해당되는 구간의 수

        for(int i=0; i<n; i++){
            if(i%2==0)
                bottom[Integer.parseInt(br.readLine())]++;
            else
                top[Integer.parseInt(br.readLine())]++;
        }
        // bottom[i] = 길이가 i인 석순의 개수
        // top[i] = 길이가 i인 종유석의 개수
        // => 누적합을 해야하는 이유

       for(int i=h-1; i>0; i--){
           top[i] += top[i+1];
           bottom[i] += bottom[i+1];
       }

       int stone[] = new int[h+1];

       for(int i=1; i<=h; i++){
           stone[i] = bottom[i] + top[h-i+1];
           min = Math.min(min, stone[i]);
       }

       for(int i=1; i<=h; i++){
           if(stone[i] == min) cnt++;
       }
        System.out.println(min+ " "+cnt);

    }
}
