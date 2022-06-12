package Programmers.SKT_2022;

import java.util.Arrays;

public class First {
    public int[] solution(int[] p) {
        int[] answer = new int[p.length];
        int min = 0;
        int min_idx = 0;
        int tmp = 0;

        for(int i=0; i<p.length; i++){
            min = Integer.MAX_VALUE;
            min_idx = i;
            for(int j=i; j<p.length; j++){
                if(min > p[j]){
                    min_idx = j;
                    min = p[j];}
            }
            if(min_idx!=i){
                tmp = p[i];
                p[i] = p[min_idx];
                p[min_idx] = tmp;
                answer[i] +=1;
                answer[min_idx] +=1;
            }
        }
        return answer;
    }

}
