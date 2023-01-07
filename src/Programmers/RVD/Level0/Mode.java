package Programmers.RVD.Level0;

import java.util.HashMap;
import java.util.Map;

public class Mode {
    public int solution(int[] array){
        int maxCnt = 0;
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int number : array){
            int count = map.getOrDefault(number, 0) + 1;
            if(count > maxCnt){
                maxCnt  = count;
                answer = number;
            }
            else if(count==maxCnt){
                answer = -1;
            }
            map.put(number, answer);
        }
        return answer;
    }
}
