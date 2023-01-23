package Reis.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 가장 왼쪽에서 정수만큼 떨어진 거리만! 물이 샌다.
        // 길이가 L인 테이프!!를 무한개 가지고 있다.
        // 그 좌우의 0.5만큼은 적어도 간격을 줘야함.
        // 필요한 테이프의 최소 개수! (겹쳐서 못하고 자를 수 없음)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물이 새는 곳의 개수
        int L = Integer.parseInt(st.nextToken()); // 테이프의 길이
        boolean[] leakingSpots = new boolean[1000+2];
        int[] indexes = new int[N];
        int index, firstIndex, count = 0, answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i= 0; i<N; i++){
            index = Integer.parseInt(st.nextToken());
            leakingSpots[index]  = true;
            indexes[i] = index;
        }

        Arrays.sort(indexes);
        firstIndex = indexes[0];

        while( firstIndex < leakingSpots.length){
           answer ++;
           firstIndex += L ;
           while (firstIndex < leakingSpots.length){
               if (leakingSpots[firstIndex]){
                   break;
               }
               firstIndex++;
           }
        }


        System.out.println(answer);
    }
}
