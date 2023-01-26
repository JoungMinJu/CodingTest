package Reis.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BOJ_2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        List<Integer> sensors;
        int[] diff;
        int answer;

        // 일직선상에 N개의 점이 있고, 그를 다 포하하는 K개의 선분을 만들어야할 때 선분 길이의 합이 최소여야하는 문제.

        if (N <= K) {
            answer = 0;
        } else {
            sensors = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toList());
            diff = IntStream.range(0, sensors.size()-1)
                    .map( i -> sensors.get(i+1) - sensors.get(i))
                    .sorted()
                    .toArray();
            answer = Arrays.stream(diff, 0, diff.length - (K - 1))
                    .sum();
        }
        System.out.println(answer);
    }

}
