package Programmers.RVD.Level0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlusBit {
    // 이진수 더하기
    public static void main(String[] args) {
        System.out.println(solution("1001","1111"));
    }

    public static String solution(String bin1, String bin2) {
        List<Integer> answer = new ArrayList<>();
        int oneIdx = bin1.length()-1;
        int twoIdx = bin2.length() -1;
        int oneValue = 0, twoValue = 0, nowValue = 0;
        int answerIdx = 0;

        while(oneIdx >=0 || twoIdx >= 0){
            oneValue = 0;
            twoValue = 0;

            if(oneIdx >= 0)
                oneValue = bin1.charAt(oneIdx--) - '0';
            if(twoIdx >= 0)
                twoValue = bin2.charAt(twoIdx--) - '0';
            nowValue = oneValue + twoValue;

            if (answerIdx < answer.size() && answer.size() != 0){
                nowValue += answer.get(answerIdx);
                answer.remove(answerIdx);
            }

            answer.add(answerIdx++, (nowValue)  % 2 );

            if(nowValue >= 2){
                answer.add(answerIdx, 1);
            }
        }

        Collections.reverse(answer);

        // List<Integer> -> String
        return answer.toString()
                .replaceAll("[^0-9]", "");

    }

}
