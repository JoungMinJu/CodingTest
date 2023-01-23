package Reis.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17509 {
    public static class Time implements Comparable<Time> {
        private int D;
        private int V;

        public Time(int d, int v) {
            D = d;
            V = v;
        }

        public int getD() {
            return D;
        }

        public int getV() {
            return V;
        }

        @Override
        public int compareTo(Time time) {
            return this.D - time.D;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Time> times = new ArrayList<>();
        int answer = 0, dAnswer = 0, D, V;

        for (int i = 0; i < 11; i++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            times.add(new Time(D, V));
        }

        Collections.sort(times);

        for (Time time : times) {
            answer += dAnswer + time.getD();
            dAnswer += time.getD();
        }

        for (Time time : times) {
            answer += 20 * time.getV();
        }

        System.out.println(answer);
    }
}
