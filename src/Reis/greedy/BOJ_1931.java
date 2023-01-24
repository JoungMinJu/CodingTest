package Reis.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1931 {
    public static class Meeting implements Comparable<Meeting>{
        private int startTime;
        private int endTIme;

        public Meeting(int startTime, int endTIme) {
            this.startTime = startTime;
            this.endTIme = endTIme;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTIme() {
            return endTIme;
        }

        @Override
        public int compareTo(Meeting meeting) {
            if (this.endTIme == meeting.endTIme) {
                return this.startTime - meeting.endTIme;
            }
            return this.endTIme - meeting.endTIme;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int lastTime = -1, answer = 0;
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(meetings);

        for (Meeting meeting : meetings) {
            if (lastTime <= meeting.getStartTime()) {
                answer ++;
                lastTime = meeting.getEndTIme();
            }
        }

        System.out.println(answer);
    }
}
