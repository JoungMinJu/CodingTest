package Programmers.Level1.Caesar;

public class Caesar {
    public String solution(String s, int n){
        String answer = "";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == ' ') answer += c;
            else{
                // 대문자
                // 91 ==> 65
                // 92 ==> 66
                // 64 ==> 90
                // 63 ==> 89
                if('A' <= c && c<='Z') {
                    char temp = (char)(c+n);
                    if(temp >'Z') temp = (char)(temp %90 + 64);
                    else if(temp<'A') temp = (char)(temp%65 + 36);
                    answer += temp;
                }
                // 소문자
                // 123 ==> 97
                // 124 ==> 98
                // 96 ==> 122
                // 95 ==> 121
                else if('a'<=c && c<= 'z'){
                    char temp  = (char)(c+n);
                    if(temp >'z') temp = (char)(temp %122 + 96);
                    else if(temp<'a') temp = (char)(temp%122 + 96);
                    answer += temp;
                }
            }
        }
        return answer;
    }

}
