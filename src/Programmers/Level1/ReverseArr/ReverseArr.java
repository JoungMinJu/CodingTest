package Programmers.Level1.ReverseArr;

import java.util.ArrayList;

public class ReverseArr {
    public int[] solution(long n){
        String tmp = Long.toString(n);
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i=tmp.length()-1; i>=0;i--){
            lst.add(tmp.charAt(i) - '0');
        }

        int[] ans = lst.stream().mapToInt(i->i).toArray();
        return ans;
    }
}
