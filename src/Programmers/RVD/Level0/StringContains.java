package Programmers.RVD.Level0;

public class StringContains {
    // 해당 문자열이 어떤 문자열 안에 포함되는지 확인하는
    public int solution(String str1, String str2) {
        return (str1.contains(str2)? 1: 2);
    }
}
