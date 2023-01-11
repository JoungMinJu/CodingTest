package Programmers.RVD.Level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NonDuplicatedString {
    public String solution(String myString){
        // String -> List<String>
        List<String> strs = new ArrayList<String>(Arrays.asList(myString.split("")));

        // List<String> -> String
        return strs.stream()
                .distinct()
                .collect(Collectors.joining());
    }
}
