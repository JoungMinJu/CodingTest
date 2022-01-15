package Programmers.Level1.PY;

public class PY {
    boolean solution(String s){
        boolean answer = true;
        s =s.toLowerCase();
        int p = 0;
        int y = 0;
        char c;
        for(int i = 0 ; i <s.length(); i++){
            c = s.charAt(i);
            if(c == 'p') p+=1;
            else if(c == 'y') y+=1;
        }
        if(p > 0 | y>0){
            if(p==y) return true;
            else return false;
        }
        return answer;
    }
}
