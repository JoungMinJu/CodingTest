package Programmers.RVD.Level0;

import java.util.Arrays;

public class StringNumbersSort {
    // 문자열내 숫자만 골라서 정렬하기
    public int[] solution(String myString){
        return Arrays.stream(myString.replaceAll("[A-Z|a-z]", "")
                .split(""))
                .sorted()
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
