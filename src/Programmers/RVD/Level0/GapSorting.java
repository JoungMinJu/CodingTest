package Programmers.RVD.Level0;

import java.util.*;

public class GapSorting {
    // 주어진 num의 gap을 기준으로 내림 차순 정렬. gap이 동일하면 원래 숫자가 큰 순서대로 정렬

    // 1. HashMap의 value 정렬
    // 2. 정렬을 재정의하여서 정렬
    // 3. Integer의 비교를 위한 equals 사용

    public int[] solution(int[] numlist, int n) {
        Map<Integer, Integer> gapByNumber = new HashMap<>();
        int[] result = new int[numlist.length];

        for(int num : numlist){
            gapByNumber.put(num, Math.abs(n - num));
        }

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(gapByNumber.entrySet());

        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
                if(o1.getValue().equals(o2.getValue())){
                    return o2.getKey() - o1.getKey();
                }
                return o1.getValue() - o2.getValue();
            }
        });

        for(int i=0; i<numlist.length; i++){
            result[i] = entryList.get(i).getKey();
        }

        return result;
    }
}
