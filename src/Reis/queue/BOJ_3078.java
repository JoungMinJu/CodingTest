package Reis.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3078 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;
        int len;
        Queue<Integer>[] ques = new LinkedList[21];

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 2; i < 21; i++)
            ques[i] = new LinkedList<>();

        for (int i= 1; i <= N; i++) {
            len = br.readLine().length();
            if (ques[len].isEmpty()) {
                ques[len].add(i);
            }
            else {
                while (!ques[len].isEmpty()) {
                    if (i - ques[len].peek() <= K ) {
                        answer += ques[len].size();
                        ques[len].add(i);
                        break;
                    }
                    ques[len].poll();
                }
                if (ques[len].isEmpty()) {
                    ques[len].add(i);
                }
            }
        }
        System.out.println(answer);
    }
}
