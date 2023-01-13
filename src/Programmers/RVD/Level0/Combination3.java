package Programmers.RVD.Level0;

import java.math.BigInteger;

public class Combination3 {
    // 조합 (+팩토리얼) 크기 큰 경우  BigInteger 활용
    public BigInteger solution(int balls, int share){
        return factorial(balls).divide(factorial(balls-share).multiply(factorial(share)));
    }

    public BigInteger factorial(int n){
        BigInteger ret = new BigInteger("1");
        BigInteger from = new BigInteger("1");
        BigInteger to = new BigInteger(String.valueOf(n));

        for(BigInteger i = from; i.compareTo(to) <= 0; i = i.add(BigInteger.ONE)){
            ret = ret.multiply(i);
        }
        return ret;
    }
}
