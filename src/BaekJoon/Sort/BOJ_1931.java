package BaekJoon.Sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


// 왜 틀렸는지 모를일
public class BOJ_1931 {
    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;
        int during;

        Meeting(int start, int end, int during) {
            this.start = start;
            this.end = end;
            this.during = during;
        }

        @Override
        public int compareTo(Meeting o) {
            // 비교하는 object와 총 지속 시간을 비교?
//            if(o.start == this.start) return this.during-o.during;
//            return this.start - o.start;
//            if(this.during == o.during) return this.end - o.end;
//            return this.during-o.during;
            if(this.end == o.end ) return this.start - o.start;
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        // 회의 수
        int n = Integer.parseInt(br.readLine());

        ArrayList<Meeting> lst = new ArrayList<>();
        // 각 회의의 시작시간, 끝나는 시간, 총 지속 시간
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lst.add(new Meeting(s, e, (e-s)));
        }

        Collections.sort(lst);

        // 가장 늦은 end 시간 찾기
        int last = -10000;
        for(Meeting m : lst){
            if(last<m.end) last = m.end;
        }

        // 그에 맞는 시간 배열 생성
        int[] time = new int[last];

        // 회의 개수
        int count = 0;

        for(Meeting m : lst){
            // 제일 먼저 시작하는 애부터 하나하나 채워나가기
            count++;
            for(int j=m.start; j<m.end; j++){
                if(time[j] == 1) {count--; break; }
                time[j] = 1;

            }
        }
//        System.out.println("time 리스트 결과입니다.");
//        for(int i : time){
//            System.out.print(i);
//        }
//        System.out.println("결과는");
        System.out.print(count);
    }
}

