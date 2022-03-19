package BaekJoon.Implementation;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_17413_adv {
    public static void main(String[] args) {
        // 스택을 쓰는 방식
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stk = new Stack<>();
        boolean inout = false;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='<'){
                inout=true;
                while(!stk.isEmpty()){
                    System.out.print(stk.pop());
                }
                //< 기호 표시
                System.out.print(s.charAt(i));
            }
            else if(s.charAt(i)=='>'){
                inout = false;
                System.out.print(s.charAt(i));
            }
            else if(inout){
                // 순서 그대로 출력
                System.out.print(s.charAt(i));
            }
            else if(!inout){
                //공백이라면
                if(s.charAt(i)==' '){
                    while(!stk.isEmpty()){
                        System.out.print(stk.pop());
                    }
                    // 공백 출력
                    System.out.print(s.charAt(i));
                }
                // 공백 아니면
                else{
                    stk.push(s.charAt(i));
                }
            }
        }
        // 나머지 스택에 저장된거 다 pop하기
        while(!stk.isEmpty()){
            System.out.print(stk.pop());
        }
    }
}
