package Programmers.RVD.Level0;

public class StringNumberSum {
    // String 안의 숫자만 골라서 다 더하기
    public int solution(String myString){
        return myString.chars()
                .mapToObj(i -> (char)i)
                .filter(Character::isDigit)
                .map(String::valueOf)
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
