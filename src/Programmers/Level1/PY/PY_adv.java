package Programmers.Level1.PY;

public class PY_adv {
    boolean solution(String s){
        s = s.toUpperCase();
        return s.chars().filter(e->'P'==e).count() == s.chars().filter(e -> 'Y'==e).count();
    }
}
