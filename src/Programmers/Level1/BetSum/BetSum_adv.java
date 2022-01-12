package Programmers.Level1.BetSum;

class BetSum_adv {
    //내꺼랑 비슷
    public long solution(int a, int b){
        return sumAtoB(Math.min(a,b), Math.max(b,a));
    }
    private long sumAtoB(long a, long b){
        return (b-a+1) * (a+b)/2;
    }

}
