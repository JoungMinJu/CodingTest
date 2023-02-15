package Reis.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Balloon> balloons = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            balloons.add(new Balloon(i, Integer.parseInt(st.nextToken())));

        while (balloons.size() > 1) {
            Balloon currentBalloon = balloons.poll();
            sb.append(currentBalloon.idx).append(" ");

            int gap = currentBalloon.num;

            if (gap < 0) {
                while (gap++ < 0)
                    balloons.addFirst(balloons.pollLast());
            } else {
                gap--;
                while (gap-- > 0)
                    balloons.addLast(balloons.pollFirst());
            }
        }
        System.out.println(sb.append(balloons.poll().idx).toString());
    }

    public static class Balloon {
        int idx, num;

        public Balloon(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
}
