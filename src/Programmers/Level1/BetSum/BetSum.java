package Programmers.Level1.BetSum;

public class BetSum {
    public long solution(int a, int b) {
        long x = (a<=b)? (long)a : (long) b;
        long y = (a>b)? (long)a : (long)b;
        long f = (y * (y+1))/2;
        long s = (x * (x-1))/2;
        return f -s;
    }
}
