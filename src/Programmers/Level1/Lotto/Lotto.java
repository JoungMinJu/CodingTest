package Programmers.Level1.Lotto;

public class Lotto {

    public int[] solution(int[] lottos, int[] win_nums) {
        //input [44,1,0,0,31,25] --> output = [3,5]
        //input [0,0,0,0,0,0] --> output = [ 1,6]
        //input [45,4,35,20,3,9] --> [1,1]
        int[] result = new int[2];
        int zero = 0;
        int correct = 0;

        for(int i : lottos){
            if(i == 0){
                zero+=1;
            }
            for(int j : win_nums) {
                if (i == j) {
                    correct += 1;
                }
            }
        }

        result[0]= grade((zero + correct));
        result[1] = grade(correct);

        return result;
    }
    int grade(int num){
        switch(num){
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;}}
}
