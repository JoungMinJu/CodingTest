package Programmers.Level1.Colatz;

public class Colatz {
    public int solution(int num){
        int ans=0;
        while(num >1){
            if(num%2==0) {num= num/2; ans++;}
            else {num = (num*3)+1; ans++;}
        }
        return (num==1)?ans:-1;
    }
}
