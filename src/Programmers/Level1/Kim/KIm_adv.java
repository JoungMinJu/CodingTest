package Programmers.Level1.Kim;

public class KIm_adv {
    public String solution(String[] seoul){
        // x에 김서방의 위치 저장
        int x= 0;
        for(int i=0;i<seoul.length;i++){
            if(seoul[i].equals("Kim")) x= i;
        }
        return "김서방은 "+ x+"에 있다";
    }
}
