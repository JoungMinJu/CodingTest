package Programmers.RVD.Level0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOneSortedString {
    // 한 번만 등장한 문자 사전순정렬
        public String solution(String s) {
            Map<Character, Integer> counts = new HashMap<>();
            List<String> strs = new ArrayList<>();

            for(int i=0; i<s.length(); i++){
                counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0)+1);
            }


            for(Character key : counts.keySet()){
                if(counts.get(key) == 1){
                    strs.add(key+"");
                }
            }


            return strs.stream()
                    .sorted()
                    .collect(Collectors.joining());
        }
}
