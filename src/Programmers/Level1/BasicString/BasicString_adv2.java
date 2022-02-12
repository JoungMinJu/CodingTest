package Programmers.Level1.BasicString;

public class BasicString_adv2 {
    public boolean solution(String s){
        if(s.length()==4||s.length()==6) return s.matches("(^[0-9]*$)");
        return false;
    }
}
