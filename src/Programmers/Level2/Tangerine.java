package Programmers.Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://school.programmers.co.kr/learn/courses/30/lessons/138476

// map에 default 값 넣는 법
// keySet 리스트로 받는 법
// 값에 따라서 keySet 정렬하는 법

public class Tangerine {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) +1);
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());

        keyList.sort((o1, o2) -> map.get(o2) - map.get(o1));
        int i = 0;

        while(k > 0) {
            k -= map.get(keyList.get(i++));
            answer++;
        }
        return answer;
    }
}
