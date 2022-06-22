package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2980 {
    static class TrafficLight{
        int  r, g;

        public TrafficLight( int r, int g) {

            this.r = r;
            this.g = g;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 도로 진입시 모든 신호등은 빨간색이고 사이클이 막 시작한 상태
        // 상근이는 1초에 1미터를 움직이고
        int n = Integer.parseInt(st.nextToken()); // 신호등의 개수
        int l = Integer.parseInt(st.nextToken()); // 도로의 길이
        // 각 신호등의 정보
        TrafficLight[] lst = new TrafficLight[l+1];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()); // 신호등의 위치
            int r = Integer.parseInt(st.nextToken()); // 빨간색이 지속되는 시간
            int g = Integer.parseInt(st.nextToken());  // 초록색이 지속되는 시간
            lst[d] = new TrafficLight(r,g);
        }
        int answer = 0;
        int pos = 0;
        while(pos<l){
            answer++;
            pos++;
            if(lst[pos]!=null){
                int t = answer % (lst[pos].r + lst[pos].g);
                if(t<=lst[pos].r){
                    answer += lst[pos].r - t;
                }
            }
        }
        System.out.println(answer);
    }
}
