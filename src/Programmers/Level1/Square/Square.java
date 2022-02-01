package Programmers.Level1.Square;

import java.util.Scanner;

public class Square {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String tmp = "*".repeat(a);
        String ans ="";
        for(int i=0;i<b;i++){
            ans += tmp;
            if(i!=(b-1)) ans+="\n";
        }
        System.out.println(ans);
    }
}
