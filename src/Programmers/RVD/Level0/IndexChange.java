package Programmers.RVD.Level0;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class IndexChange {
    public String solution(String myString, int num1, int num2){
        List<String> lst = Arrays.stream(myString.split(""))
                .collect(Collectors.toList());

        Collections.swap(lst, num1, num2);
        return String.join("", lst);
    }
}
