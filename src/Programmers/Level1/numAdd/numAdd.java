package Programmers.Level1.numAdd;

public class numAdd {
    public int solution(int[] numbers){
        int answer = -1;
        answer = 0;
        int[] ans = new int[10];
        for(int num : numbers){
            ans[num] = 1;
        }
        for(int i=0; i<10; i++){
            if(ans[i]==0){
                answer +=i;
            }
        }
        return answer;
    }
}
