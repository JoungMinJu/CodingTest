package Programmers.Level1.id;

import org.w3c.dom.ls.LSOutput;

import java.util.Locale;

// 신규 id 추천
public class id {
    public String solution(String new_id) {
        String answer = "";
        //1단계
        answer = new_id.toLowerCase();
        //2단계
        answer = answer.replaceAll("[^a-z\\d\\-_.]*","");
        // - 참고 : temp = temp.replaceAll("[^-_.a-z0-9]","");
        //3단계
        answer = answer.replaceAll("\\.{2,}",".");
        // - 참고 : temp = temp.replaceAll("[.]{2,}",".");
        //        : temp = temp.replaceAll("^[.]|[.]$","");
        //4단계
        char first = answer.charAt(0);
        if (first == '.'){
            answer=answer.substring(1);
        }
        if(answer.length() != 0){
            char last = answer.charAt(answer.length() - 1);
            if(last == '.'){
                answer = answer.substring(0, answer.length() -1);
            }}
        //5단계
        if (answer.length() == 0){
            answer +="a";
        }
        //6단계
        if(answer.length()>=16) {
            answer = answer.substring(0, 15);
            char last_2 = answer.charAt(answer.length()-1);
            if (last_2 == '.') {
                answer = answer.substring(0, 14);
            }
        }
        //7단계
        while(answer.length() < 3){
            char last_3 = answer.charAt(answer.length()-1);
            String l = String.valueOf(last_3);
            answer +=l;
        }
        return answer;
    }


}
