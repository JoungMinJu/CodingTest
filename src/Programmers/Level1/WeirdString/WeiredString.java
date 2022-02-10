package Programmers.Level1.WeirdString;

public class WeiredString {
    public String solution(String s){
        String[] arr = s.split(" ");
        String answer = "";
        char c;
        for(String temp : arr){
            for(int i=0;i<temp.length();i++){
                c=temp.charAt(i);
                answer += change(c,i);
            }
            if(temp.equals(arr[arr.length-1])) break;
            answer +=" ";
        }

        return answer;
    }
    public char change(char c, int index){
        // 짝수 대문자
        // 홀수 소문자
        if('A'<=c && c<='Z'){
            return (index%2==0)?c: (char)(c+32);
        }
        else if('a'<=c && c<='z'){
            return (index%2==0)?(char)(c-32):c;
        }
        return 0;
    }
}
