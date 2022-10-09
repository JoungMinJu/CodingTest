package SSW;

class Lotto {
    public int[] solution(int[] lottos, int[] win_nums) {
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

        result[1]=grade(correct);
        result[0] = grade((zero + correct));

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