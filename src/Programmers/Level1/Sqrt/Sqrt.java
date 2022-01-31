package Programmers.Level1.Sqrt;

public class Sqrt {
    public long solution(long n){
        long tmp = (long) Math.sqrt(n);
        if(n==Math.pow(tmp,2)){
            return (long)(Math.pow(tmp+1, 2));
        }
        else{
            return -1;
        }
    }
}
