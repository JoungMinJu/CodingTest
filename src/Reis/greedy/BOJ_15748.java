package Reis.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// L 미터의 직선적인 트레일
// 미터당 r_F초의 일정한 이동속도
// [베시]
// N개의 휴개소
// i 번째 정류장은 산책로 시작부터 x_i m에 있고, ci 가치 가짐.
// t초동안 i정치에서 휴식 취하면 ci*t의 unit 받음.
// r_b초의 고정 이동 속도 (R_b < r_f)

public class BOJ_15748 {
    public static class Stop implements Comparable<Stop>{
        private Long meter;
        private Long value;

        public Stop(long meter, long value) {
            this.meter = meter;
            this.value = value;
        }

        public long getMeter() {
            return meter;
        }

        public long getValue() {
            return value;
        }

        @Override
        public int compareTo(Stop stop) {
            return stop.value.compareTo(this.value);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Stop> stops = new PriorityQueue<>();

        long L = Integer.parseInt(st.nextToken());
        long N = Integer.parseInt(st.nextToken());
        long rF = Integer.parseInt(st.nextToken());
        long rB = Integer.parseInt(st.nextToken());
        long bessiePos = 0;
        BigInteger answer =  BigInteger.ZERO;

        // 앞으로 남은 놈들 중 가장 값이 큰 곳에서 !! 오래 쉬는게 낫다 -> 그리디
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            stops.add(new Stop(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        while (!stops.isEmpty()) {
            Stop nowStop = stops.poll();
            if (bessiePos <= nowStop.getMeter()) {
                answer = answer.add(BigInteger.valueOf(rF-rB)
                        .multiply(BigInteger.valueOf(nowStop.getMeter() - bessiePos))
                        .multiply(BigInteger.valueOf(nowStop.getValue())));
                bessiePos = nowStop.getMeter();
            }
        }

        System.out.println(answer);
    }
}
