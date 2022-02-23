package Programmers.Level1.Hasshad;

public class Hasshad {
    public boolean solution(int x){
        int tmp = x;
        int dv= 0;

        while(tmp>0){
            dv += tmp %10;
            tmp = tmp /10;
        }

        return x%dv ==0;
    }
}
