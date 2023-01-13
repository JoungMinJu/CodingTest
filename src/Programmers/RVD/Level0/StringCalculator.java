package Programmers.RVD.Level0;

import java.util.Arrays;

public class StringCalculator {
    public static void main(String[] args) {
        System.out.println(solution("3 + 6 - 3"));
    }
    public static int solution(String myString){
        return Arrays.stream(myString.replaceAll("- ", "-")
                        .replaceAll("[+] ", "")
                        .trim()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
