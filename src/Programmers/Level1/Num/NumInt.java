package Programmers.Level1.Num;

public class NumInt {
    //숫자 문자열과 영단어
    public int solution(String s){
        //s의 길이 <=50
        //s가 0으로 시작하는 경우는 없음
        String temp = new String();
        temp = s.replaceAll("zero","0");
        temp = temp.replaceAll("one","1");
        temp = temp.replaceAll("two","2");
        temp = temp.replaceAll("three","3");
        temp = temp.replaceAll("four","4");
        temp = temp.replaceAll("five","5");
        temp = temp.replaceAll("six","6");
        temp = temp.replaceAll("seven","7");
        temp = temp.replaceAll("eight","8");
        temp = temp.replaceAll("nine","9");

        int answer = 0;
        for(int i = 0; i<temp.length();i++){
            answer += (temp.charAt(i)-'0') * Math.pow(10,temp.length()-i-1);
        }
        return answer;
    }
}
