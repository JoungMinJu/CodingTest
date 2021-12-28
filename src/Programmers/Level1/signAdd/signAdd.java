package Programmers.Level1.signAdd;

public class signAdd {
    public int solution(int[] absolutes, boolean[] signs){
        int answer = 123456789;
        answer =0;
        for(int i=0; i<absolutes.length;i++){
            if(signs[i]){
                answer +=absolutes[i];
            }
            else{
                answer -=absolutes[i];
            }
        }
        return answer;
    }
}
