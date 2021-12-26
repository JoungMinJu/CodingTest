package Programmers.Level1.KeyPad;

public class KeyPadAdvanced {
    //        0부터 9까지 좌표 {y,x}
    int[][] numpadPos = {
            {3,1}, //0
            {0,0}, //1
            {0,1}, //2
            {0,2}, //3
            {1,0}, //4
            {1,1}, //5
            {1,2}, //6
            {2,0}, //7
            {2,1}, //8
            {2,2}  //9
    };
    //초기 위치
    int[] leftPos = {3,0};
    int[] rightPos = {3,2};
    String hand;

    public String solution(int[] numbers, String hand){
        this.hand= (hand.equals("right"))? "R" : "L";
        String answer = "";
        for(int num : numbers){
            String Umji = pushNumber(num);
            answer += Umji;

            if(Umji.equals("L")) {leftPos = numpadPos[num]; continue;}
            if(Umji.equals("R")) {rightPos = numpadPos[num]; continue;}
        }
        return answer;
    }
    //num 버튼 누를때 어떤 손 사용하는가
    private String pushNumber(int num){
        if(num ==1 || num == 4 || num==7) return "L";
        else if(num == 3| num==6|| num==9) return "R";
        else {
            if (getDist(leftPos, num) > getDist(rightPos, num)) return "R";
            if (getDist(leftPos, num) < getDist(rightPos, num)) return "L";
        }
        return this.hand;
    }
    //거리 계산
    private int getDist(int[] pos, int num){
        return Math.abs(pos[0] - numpadPos[num][0]) + Math.abs(pos[1]-numpadPos[num][1]);
    }
}
