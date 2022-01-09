package Programmers.Level1.TwoAdd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class TwoAdd {
    public int[] solution(int[] numbers){
        int[] answer = {};
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ;i<numbers.length;i++){
            for(int  j = i+1 ; j<numbers.length;j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        //set을 list로 변환
        List res = new ArrayList(set);
        Collections.sort(res);
        answer = res.stream().mapToInt(i-> (int) i).toArray();
        return answer;
    }
}
