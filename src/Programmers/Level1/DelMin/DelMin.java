package Programmers.Level1.DelMin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DelMin {
    public int[] solution(int[] arr){
        if(arr.length <=1) { return new int[]{-1};}
       List<Integer> lst = Arrays.stream(arr).boxed().collect(Collectors.toList());
       Arrays.sort(arr);
       int min = arr[0];
       lst.remove(Integer.valueOf(min));
       int[] answer = lst.stream().mapToInt(i->i).toArray();
       return answer;
    }
}
