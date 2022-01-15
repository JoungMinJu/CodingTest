package Programmers.Level1.DisNum;
import java.util.*;

public class DisNum {
        public int[] solution(int []arr) {
            List<Integer> lst = new ArrayList<>();
            int prev = -1;
            for(int i : arr){
                if(prev != i) lst.add(i);
                prev = i;
            }
            int[] answer = lst.stream().mapToInt(Integer::intValue).toArray();
            return answer;
    }
}
