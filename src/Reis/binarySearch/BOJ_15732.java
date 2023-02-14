package Reis.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15732 {
    static class Rule {
        int start;
        int end;
        int unit;

        public Rule(int start, int end, int unit) {
            this.start = start;
            this.end = end;
            this.unit = unit;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 상자의 개수
        int K = Integer.parseInt(st.nextToken()); // 규칙의 개수
        int D = Integer.parseInt(st.nextToken()); // 도토리의 개수

        // 줄여나가는 범위 = 상자의 번호
        // mid값이 정해지면 -> 해당 번호까지 도토리를 몇 개 넣을 수 있는지 계산
        List<Rule> rules = new ArrayList<>();

        for (int i = 0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            rules.add(new Rule(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int left = 1;
        int right = N;

        while (left <= right) {
            int mid = (left + right) /2;
            long cnt = 0;
            for (Rule rule : rules) {
                if(rule.end <= mid ) {
                    cnt += (rule.end - rule.start) / rule.unit + 1;
                }
                else if (rule.start <= mid) {
                    cnt += (mid - rule.start) / rule.unit +1;
                }
            }
            if (cnt >= D) {
                right = mid -1;
            }
            else {
                left = mid +1;
            }
        }
        System.out.println(left);
    }
}
