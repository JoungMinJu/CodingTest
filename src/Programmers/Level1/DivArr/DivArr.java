package Programmers.Level1.DivArr;


import java.util.ArrayList;
import java.util.Arrays;


public class DivArr {
    public int[] solution(int[] arr, int divisor){
        ArrayList<Integer> lst = new ArrayList<>();
        for(int a : arr){
            if(a%divisor==0) lst.add(a);
        }
        if(lst.isEmpty()) lst.add(-1);
        int[] ans = lst.stream().mapToInt(i->i).toArray();
        Arrays.sort(ans);
        return ans;
    }
}
