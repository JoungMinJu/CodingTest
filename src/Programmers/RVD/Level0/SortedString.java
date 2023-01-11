package Programmers.RVD.Level0;

import java.util.Arrays;

public class SortedString {
    public String solution(String myString){
        char[] chars = myString.toLowerCase()
                .toCharArray();

        Arrays.sort(chars);

        return new String(chars);
    }
}
