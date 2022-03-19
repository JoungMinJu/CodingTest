package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 소문자 숫자 공백 특수문자로만 이루어진 문자 s
        // <>로 등장하는 경우 두 문자의 개수는 같다.
        // <길이가 3이사인 부분 문자열 + 알파벳소문자와 공백만 있다>
        // 연속하는 두 단어는 공백 하나로 구분한다. 태그는 단어가 아니며 태그와 단어 사이에는 공백이 없다.
        String s = br.readLine();
        String temp = "";
        String answer = "";
        boolean check = false;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='<'){
                StringBuffer sb = new StringBuffer(temp);
                answer+= sb.reverse().toString();
                answer+=c;
                temp = "";
                check = true;}
            else if(c=='>'){
                answer+=c;
                check = false;}
            else if(check){
                answer+=c;
            }
            // 공백
            else if(!check && c==' '){
                StringBuffer sb = new StringBuffer(temp);
                answer+= sb.reverse().toString();
                answer+=c;
                temp = "";
            }
            else if (!check){
                temp +=c;}

    }

        if(!temp.isEmpty()){
            StringBuffer sb = new StringBuffer(temp);
            answer+= sb.reverse().toString();
            temp = "";
        }
        System.out.println(answer);
}}
