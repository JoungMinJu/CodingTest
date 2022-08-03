package study.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. i=0인 경우
 *  i=1과 같지만 않으면 됨
 * 2. i=n-1인 경우
 *  i=n-2와 같지만 않으면 됨
 * 3. 다른 경우
 *    (1)
 */

public class BOJ_1149 {

    static class Color implements Comparable<Color>{
        String name;
        int price;

        public Color(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public int compareTo(Color o) {
            return this.price >= o.price ? 1 : -1;
        }
    }

    static class House{
        PriorityQueue<Color> pq;

        public House(){
            this.pq = new PriorityQueue<>();
        }

        public void add_pq(Color c){
            this.pq.add(c);
        }

        public int get_price() {
            return this.pq.peek().price;
        }

        public String get_name(){
            return this.pq.peek().name;
        }

        public void remove_first(){
            this.pq.poll();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 집의 개수
        String[] color_set = {"r","g","b"};
        House[] lst = new House[n];

        for(int i=0; i<n; i++){
            lst[i] = new House();
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                int tmp = Integer.parseInt(st.nextToken());
                lst[i].add_pq(new Color(color_set[j], tmp));
            }
        }
        // 각 집이 나열되어있는 lst 배열, 그 각각 House 안에 있는 dq는 COlor가 작은 순서대로 있음.
        int answer = 0;
        String before_color = "";
        answer = lst[0].get_price();
        before_color = lst[0].get_name();

        for(int i=1; i<n; i++){
            House now = lst[i];
            while(now.get_name().equals(before_color)){
                now.remove_first();
            }
            answer += now.get_price();
            before_color = now.get_name();
        }
        System.out.println(answer);
    }
}
