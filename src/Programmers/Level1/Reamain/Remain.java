package Programmers.Level1.Reamain;

public class Remain {
    public long solution(int price, int money, int count) {
        // 누적합
        long answer = (long)price*((long)count*((long)count+1)/2);
        if(answer > money ) return answer-money;
        return 0;
    }
}

// 알고보니 한 줄로도 가능했다
// public long solution(long price, long money, long count) {
//        return Math.max(price * (count * (count + 1) / 2) - money, 0);
//    }
