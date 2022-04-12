package Algorithm_Two.CH6.Fibonacci;

import java.util.Scanner;

public class TopDown {
    // 큰 문제 해결하기 위해서 작은 문제 호출하는 방식
    static int[] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        D = new int[n+1];
        // 전체 배열 초기화
        for(int i=0;i<=n;i++) D[i] = -1;

        // 초기값 세팅
        D[0]=0;
        D[1]=1;

        fibo(n);
        System.out.println(D[n]);
    }
    static int fibo(int n){
        if(D[n]!=-1) // 기존에 계산한 적이 있는 부분 문제는 다시 계산하지 않고 리턴
        {return D[n];}

        return D[n] =fibo(n-2)+fibo(n-1);
    }
}
