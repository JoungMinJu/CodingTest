package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1946 {

    public static class Score implements Comparable<Score>{
        int x;
        int y;

        public Score(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Score o) {
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int t = Integer.parseInt(br.readLine());
        ArrayList<Score> lst;
        for(int i=0;i<t;i++) {
            int n = Integer.parseInt(br.readLine());
            lst = new ArrayList<>();
            for(int j=0;j<n;j++){
                st = new StringTokenizer(br.readLine());
                int x= Integer.parseInt(st.nextToken());
                int y= Integer.parseInt(st.nextToken());
                lst.add(new Score(x,y));
            }

            //x순으로 정렬했음
            Collections.sort(lst);

            int answer = 1;
            int now_y = lst.get(0).y;

            // x등수가 더 높은 애들의 y값보다, 내가 가진 y값이 더 높으면 count될 수 있다
            for(int j=1;j<n;j++){
                Score check = lst.get(j);
                if(check.y < now_y) {answer++; now_y = check.y;}
            }
            System.out.println(answer);
        }
    }
}
