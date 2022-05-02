package Algorithm_Two.CH9.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Change {
    public static void main(String[] args) throws IOException {
        int[] coinValue ={500,100,50,10,5,1};
        int i; // 동전들의 액면가 배열 지수
        int[] numCoin; // 거스름돈에 포홤되는 각 동전의 수 배열
        int change; // 남은 거스름돈
        int count = 0; // 거스름돈에 포함되는 동전들의 수
        numCoin = new int [6];
        Scanner sc= new Scanner(System.in);
        // 거스름돈에 포함되는 각 동전의 수를 0으로 초기화한다.
        for(i=0;i<numCoin.length;i++){
            numCoin[i] = 0;
        }
        System.out.println("거스름돈을 입력하세요[0-999]:");
        change =sc.nextInt();
        i = 0;
        System.out.println(change +"원의 거스름돈은 다음과 같다:");
        while(change>0){
            numCoin[i] = change/coinValue[i];
            change %= coinValue[i];
            if(numCoin[i] >0) System.out.println(coinValue[i]+"원짜리 동전 "+numCoin[i]+"개");
            i++;
        }
    }
    static int coinChanged(int d[], int m, int n){
        // d는 동전들의 액면ㄱ가를 저장하는 배열 내림차순
        // m은 액면가ㅏㄱ 다른 동전들의 수
        // n은 거스름돈
        int count = 0;
        int i=1;
        while(n>0 && i<=m){
            count += n/d[i];
            n %= d[i];
            i+=1;
        }
        return count;
    }


}
