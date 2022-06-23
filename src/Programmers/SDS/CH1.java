package Programmers.SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CH1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n, m, d;
        int t = Integer.parseInt(br.readLine());
        int now_oil; // di 일에 사용 가능한 기름의 양
        int now_grass; // di일에 자를 잔디의 길이를 저장하는 임시 변수
        int now_cut; // di 일에 자른 잔디의 길이
        long answer; // 최종 답
        PriorityQueue<Integer> grass;
        Queue<Integer> oil;

        for(int test=0; test<t; test++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            grass =  new PriorityQueue<>(Collections.reverseOrder());
            oil = new LinkedList<>();
            answer = 0L;

            // 입력
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<m; j++)
                    grass.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<d; i++)
                oil.add(Integer.parseInt(st.nextToken()));

            // 계산 시작
            for(int day=1;day<=d;day++){
                now_oil = oil.poll();
                now_cut = 0;
                for(int j=0; j<now_oil; j++){
                    now_grass = grass.poll() + day;
                    now_cut += now_grass -1;
                    grass.add(1-day);
                }
                answer += day*now_cut;
            }
            System.out.println("#"+(test+1)+" "+answer);
        }
    }
}
