package ssafy.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        // 가로 길이 항상 100, 모든 위치에서 높이 1 이상 100 이하
        // 덤프 횟수은 1이상 1000이하
        PriorityQueue<Integer> minPq;
        PriorityQueue<Integer> maxPq;
        int testSize = 10;
        int dumpCnt = 0;
        for(int test = 1; test<=testSize; test++){
            dumpCnt = Integer.parseInt(br.readLine());
            minPq = new PriorityQueue<>();
            maxPq = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());
            for(int idx = 0; idx < 100; idx++){
                int tmp = Integer.parseInt(st.nextToken());
                minPq.add(tmp);
                maxPq.add(tmp);
            }
            for(int dump = 0; dump < dumpCnt; dump++){
                int min = minPq.poll();
                int max = maxPq.poll();
                min += 1;
                max -= 1;
                minPq.add(min);
                maxPq.add(max);
            }

            sb.append("#").append(test)
                    .append(" ")
                    .append(maxPq.poll() - minPq.poll())
                    .append("\n");
        }
        System.out.println(sb.toString());
    }
}
