package Reis.greedy;

import ssafy.D2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> order = new ArrayList<>();
        List<Integer> multiTap = new ArrayList<>();
        boolean[] isUsed = new boolean[101];
        int answer = 0, now, nowIndex = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            order.add(Integer.parseInt(st.nextToken()));
        }

        while(nowIndex < K) {
            now = order.get(nowIndex++);
            order.set(nowIndex-1, -1);
            if (!isUsed[now]) { // 사용되지 않고 있는데
               if (multiTap.size() < N) { // 공간이 남으면
                   multiTap.add(now);
                   isUsed[now] = true;
               }
               else { // 공간이 안남는데
                   answer ++;
                   boolean isFinish = false;
                   for (Integer plug : multiTap) {
                        if (!order.contains(plug)){ // 더이상 사용되지 않는 놈이 있다면
                            isUsed[plug] = false;
                            multiTap.remove(plug);
                            multiTap.add(now); // 딴거 끼움
                            isUsed[now] = true;
                            isFinish = true;
                            break;
                        }
                   }
                   if (! isFinish ) { // 더이상 사용되지 않는 놈이 없다면
                       int maxOrder = -1;
                       Integer maxOrderPlug = -1;
                       for (int i = 0; i<multiTap.size(); i++){
                           if(maxOrder < order.indexOf(multiTap.get(i))) {
                               maxOrder = order.indexOf(multiTap.get(i));
                               maxOrderPlug = multiTap.get(i);
                           }
                       }
                       isUsed[maxOrderPlug] = false;
                       multiTap.remove(maxOrderPlug);
                       multiTap.add(now); // 딴거 끼움
                       isUsed[now] = true;
                   }

               }

            }
        }
        System.out.println(answer);
    }
}
