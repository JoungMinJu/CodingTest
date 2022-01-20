package BaekJoon.Implementation;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;

public class BOJ_21918_SC {
    public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] status = new int[N];
    for(int i=0;i<N;i++){
        status[i] = sc.nextInt();
    }
    int[][] command = new int[M][3];
    for(int i=0;i<M;i++){
        for(int j=0;j<3;j++){
            command[i][j] = sc.nextInt();
        }
    }

    // 1 i x : i번째 전구의 상태를 x로 변경
    // 2 l r : l~r 번째까지의 전구의 상태를 변경한다
    // 3 l r : l~r 번째까지의 전구를 끈다.
    //4 l r : l~r번째까지의 전구를 킨다.


    int index = 0;
        while(true){
        if(index >=M) break;
        switch(command[index][0]){
            case 1:
                status[command[index][1]-1] = command[index][2];
                break;
            case 2:
                for(int i=command[index][1]-1; i<=command[index][2]-1;i++){
                    status[i] = turn(status[i]);
                }
                break;
            case 3:
                for(int i=command[index][1]-1; i<=command[index][2]-1;i++){
                    status[i] = 0;
                }
                break;
            case 4:
                for(int i=command[index][1]-1; i<=command[index][2]-1;i++){
                    status[i]=1;
                }
                break;
        }
        index ++;
    }

        for(int i=0; i< status.length; i++){
            System.out.print(status[i]+" ");
    }

}
    public static int turn(int s){
        if(s==0) return 1;
        else return 0;
    }
}
