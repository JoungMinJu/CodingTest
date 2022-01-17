package Programmers.Level1.Watmel;

// 천재같어
public class Watmel_adv {
    public String solution(int n){
        return new String(new char [n/2+1]).replace("\0","수박").substring(0,n);
    }
}


// 천재같은거 두번째
//public String watermelon(int n){
//    String result = "";
//    for(int i=0; i<n ; i++){
//        result += i%2 ==0 ?"수":"박";
//        return result;
//    }
//}