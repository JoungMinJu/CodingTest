package Programmers.SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CH1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n, m, d;
        int t = Integer.parseInt(br.readLine());
        int now_oil; // di 일에 사용 가능한 기름의 양
        int now_grass; // di일에 자를 잔디의 길이를 저장하는 임시 변수
        int now_cut; // di 일에 자른 잔디의 길이
        long answer; // 최종 답
        PriorityQueue<Integer> grass;

        for(int test=0; test<t; test++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            grass = new PriorityQueue<>(Collections.reverseOrder());
            answer = 0L;

            // 입력
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++)
                    grass.add(Integer.parseInt(st.nextToken()));
            }

            // 입력과 함께 계산 시작
            st = new StringTokenizer(br.readLine());
            for (int day = 1; day <= d; day++){
                now_oil = Integer.parseInt(st.nextToken());
                now_cut = 0;
                for (int j = 0; j < now_oil; j++) {
                    now_grass = grass.poll() + day;
                    now_cut += now_grass - 1;
                    grass.add(1 - day);
                 }
                answer += day * now_cut;
        }
            sb.append("#"+(test+1)+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
