package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 자신의 위치에서 거리가 k 이하인 햄버거를 먹을 수 있다.
        st = new StringTokenizer(br.readLine());
        // 식탁의 길이
        int n = Integer.parseInt(st.nextToken());
        // 선택할 수 있는 거리
        int k = Integer.parseInt(st.nextToken());
        // 테이블
        HashMap<Integer, Character> table = new HashMap<>();
        // 사람 인덱스
        ArrayList<Integer> people = new ArrayList<>();
        String temp = br.readLine();
        for(int i=0;i<n;i++){
            char t = temp.charAt(i);
            table.put(i, t);
            if(t=='P') people.add(i);
        }

        int answer = 0;

        for (Integer i : people) {
            int start = (i-k)<=0 ? 0 : (i-k);
            int end = (i+k)>=n ? n-1 : (i+k);
            for(int j=start; j<=end; j++){
                if(table.get(j) == 'H'){
                    answer ++;
                    table.replace(j, '_');
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
