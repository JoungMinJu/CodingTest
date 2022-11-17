package ssafy.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] scores;
        int max, answer, now;

        for(int testCase = 1; testCase <= t; testCase++){
            int testIdx = Integer.parseInt(br.readLine());
            scores = new int[101];
            st = new StringTokenizer(br.readLine());
            max = -1;
            answer = 0;
            while(st.hasMoreTokens()){
                now = Integer.parseInt(st.nextToken());
                scores[now] ++;
                if(max <= scores[now]){
                    max =scores[now];
                    answer = now;
                }
            }

            sb.append("#").append(testIdx).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }


}
