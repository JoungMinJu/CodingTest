package Programmers.Level1.Watmel;

public class Watmel {
    public String solution(int n) {
        String rep = "수박";
        if (n % 2 == 0) return rep.repeat(n / 2);
        else return rep.repeat(n / 2) + "수";
    }
}
