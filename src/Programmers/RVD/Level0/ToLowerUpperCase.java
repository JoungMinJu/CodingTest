package Programmers.RVD.Level0;

import java.util.stream.Collectors;

public class ToLowerUpperCase {
    // 대문자는 소문자로
    // 소문자는 대문자로

    public String solution(String myString){
        return myString.chars().
                mapToObj(operand -> String.valueOf((char) (Character.isLowerCase(operand) ? Character.toUpperCase(operand) : Character.toLowerCase(operand))))
                .collect(Collectors.joining());
    }
}
