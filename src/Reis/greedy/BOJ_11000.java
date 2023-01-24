package Reis.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11000 {
    public static class Class implements Comparable<Class> {
        private int startTime;
        private int endTime;

        public Class(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        @Override
        public int compareTo(Class aClass) {
            if (aClass.startTime == this.startTime) {
                return this.endTime - aClass.endTime;
            }
            return this.startTime - aClass.startTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Class> classes = new ArrayList<>();
        PriorityQueue<Integer> lastTimes = new PriorityQueue<>();
        int answer = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            classes.add(new Class(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(classes);

        for (Class aClass : classes) {
            if (lastTimes.isEmpty()) {
                answer++;
                lastTimes.add(aClass.getEndTime());
            } else if (lastTimes.peek() <= aClass.getStartTime()) {;
                lastTimes.poll();
                lastTimes.add(aClass.getEndTime());
            } else {
                answer++;
                lastTimes.add(aClass.getEndTime());
            }
        }

        System.out.println(answer);
    }
}
