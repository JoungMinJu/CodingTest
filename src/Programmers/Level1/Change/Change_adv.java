package Programmers.Level1.Change;

public class Change_adv {
    public int solution(String str){
        boolean Sign = true;
        int result = 0;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '-') Sign = false;
            else if(ch != '+') result = result * 10 + (ch-'0');
        }
        return Sign ? 1 : -1 * result;
    }
}
