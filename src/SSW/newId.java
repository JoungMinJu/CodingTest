package SSW;

import java.util.*;

class newId {
    public String solution(String new_id) {
        String answer = "";
        //1
        answer = new_id.toLowerCase();
        //2 (소문자 + 숫자)\w + 빼기 + 밑줄 + 마침표
        answer = answer.replaceAll("[^0-9a-z-_.]", "");
        // 3. 마침표가 두 번 이상연속된거 하나의 마침표
        answer = answer.replaceAll("[.]{2,}", ".");
        // 4단계
        answer = answer.replaceAll("^[.]|[.]$", "");
        // 5
        answer = (answer.equals("")) ? "a" : answer;
        // 6
        answer = (answer.length() >= 16) ? answer.substring(0,15) : answer;
        answer = answer.replaceAll("^[.]|[.]$", "");
        // 7
        char last = answer.charAt(answer.length()-1);
        while(answer.length()<=2){
            answer += last;
        }
        return answer;
    }
}