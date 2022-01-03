package Programmers.Level1.GymSuit;
public class GymSuit_adv {
    public int solution(int n, int[] lost, int[] reserve){
        int[] people = new int [n];
        int answer = n;

        // 천재같어
        for(int l : lost){
            people[l-1] --;
        }
        for(int r : reserve){
            people[r-1]++;
        }

        for(int i =0; i<people.length;i++){
            if(people[i] == -1){
                //없으면
                if(i-1>=0 && people[i-1] == 1){
                    //이전 사람한테 빌리기
                    people[i]++;
                    people[i-1]--;
                }else if ( i+1 <people.length && people[i+1] == 1){
                    // 뒤에 사람한테 빌리기
                    people[i]++;
                    people[i+1]--;
                }else{
                    // people[i[ == -1인데 아무것도 충족 못하면 걍 빼버리기
                    answer --;
                }
            }}
            return answer;
        }


}
