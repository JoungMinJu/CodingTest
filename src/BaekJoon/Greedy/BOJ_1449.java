package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 길이가 L인 테이프를 무한개 가지고 있고
        // 테이프 이용해서 물을 막으려고하고, 그 위치의 좌우 0.5만큼의 간격을 주어야함
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] pos = new int[n];
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            pos[i]=Integer.parseInt(st.nextToken());
        }
        // 정렬
        Arrays.sort(pos);
        // 탐색
        int answer =1;
        int compare_idx = 0;
        for(int i=compare_idx+1;i<n;i++){
            if(pos[i]-pos[compare_idx] > l-1){
                answer++;
                compare_idx = i;
            }
        }
        System.out.println(answer);
    }
}
