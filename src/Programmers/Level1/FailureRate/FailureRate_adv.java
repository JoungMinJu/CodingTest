package Programmers.Level1.FailureRate;

public class FailureRate_adv {

    public static int[] solution(int N, int[] stages){
        int[] answer =new int[N];
        double[] tempArr = new double[N];
        int arrlength = stages.length;
        int idx = arrlength;
        double tempD = 0;
        double tempI = 0;
        for(int i=0;i< arrlength; i++){
            int stage = stages[i];
            if(stage != N+1){
                answer[stage -1 ] ++;
            }
        }
        for(int i= 0; i< N; i++){
            int personNum = answer[i];
            tempArr[i] = (double) personNum / idx;
            idx -= personNum;
            answer[i] = i+1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N - i; j++) {
                if (tempArr[j - 1] < tempArr[j]) {
                    tempD = tempArr[j - 1];
                    tempArr[j - 1] = tempArr[j];
                    tempArr[j] = tempD;

                    tempI = answer[j - 1];
                    answer[j - 1] = answer[j];
                    answer[j] = (int) tempI;
                }
            }
        }
        return answer;
    }
}
