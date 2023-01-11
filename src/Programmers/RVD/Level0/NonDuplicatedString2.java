package Programmers.RVD.Level0;

import java.util.stream.Collectors;

public class NonDuplicatedString2 {
    public String solution(String myString){
        return myString.chars()
                .mapToObj(Character::toString)
                .distinct()
                .collect(Collectors.joining());
    }
}
