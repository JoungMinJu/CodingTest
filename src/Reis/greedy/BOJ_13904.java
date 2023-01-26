package Reis.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13904 {
    public static class Assignment implements Comparable<Assignment> {
        private int dDay;
        private int score;
        private boolean alreadySuccess;

        public Assignment(int dDay, int score) {
            this.dDay = dDay;
            this.score = score;
            this.alreadySuccess = false;
        }

        public int getdDay() {
            return dDay;
        }

        public int getScore() {
            return score;
        }

        public void success() {
            this.alreadySuccess = true;
        }

        public boolean isAlreadySuccess() {
            return alreadySuccess;
        }

        @Override
        public int compareTo(Assignment assignment) {
            if (assignment.getdDay() == this.getdDay()) {
                return assignment.getScore() - this.getScore();
            }
            return assignment.getdDay() - this.getdDay();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Assignment> assignments = new ArrayList<>();
        int score = 0;
        int maxIdx = -1, maxScore = -1;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            assignments.add(new Assignment(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(assignments);

        for (int day = assignments.get(0).getdDay(); day > 0; day--) {
            maxScore = -1;
            for (int i = 0; i < assignments.size(); i++) {
                Assignment assignment = assignments.get(i);
                if (assignment.getdDay() >= day) {
                    if (maxScore < assignment.getScore()) {
                        maxScore = assignment.getScore();
                        maxIdx = i;
                    }
                }
            }

            if(maxScore != -1) {
                score += maxScore;
                assignments.remove(maxIdx);
            }

        }

        System.out.println(score);
    }
}
