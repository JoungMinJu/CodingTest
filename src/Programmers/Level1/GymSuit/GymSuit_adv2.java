package Programmers.Level1.GymSuit;
import java.util.HashSet;

public class GymSuit_adv2 {
    public int solution(int n, int[] lost, int[] reserve){
        int answer = n - lost.length;
        HashSet<Integer> ko = new HashSet<Integer>();
        for(int k : reserve){
            ko.add(k);
        }//여분 가져온 애들 ko에 넣음.
        for(int i=0;i<lost.length;i++){
            if(ko.contains(lost[i])){
                //여분 가져왔는데 잃어버렸으면
                answer++;
                ko.remove(lost[i]);
                // 잃어버린 애에서도 삭제함
                lost[i] = -1;
            }
        }
        for(int i= 0;i<lost.length;i++){
            if(ko.contains(lost[i] -1 )){
                answer ++;
                ko.remove(lost[i]-1);
            }else if(ko.contains(lost[i]+1)){
                answer ++;
                ko.remove(lost[i]+1);
            }

        }
        return answer;
    }
}
