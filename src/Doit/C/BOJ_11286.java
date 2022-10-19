package DoIt.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> {
            // 우선순위 큐 정렬 조건 재정의
            int first = Math.abs(o1);
            int second = Math.abs(o2);
            if(first == second)
                return o1 - o2;
//                return o1 > o2 ? 1 : -1; // 절댓값이 같으면 음수 선 정렬
            // 기준값 o1 > 비교 값 o2이면 양수 리턴 -> 오름차순
            // 기준값 o1 < 비교 값 o1이면 음수 리턴 -> 내림차순
            else
                return first - second;
        });
        for(int i=0; i<N; i++){
            int now = Integer.parseInt(br.readLine());
            if(now == 0){
                if (que.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(que.poll());
            }
            else
                que.add(now);
        }

    }
}
