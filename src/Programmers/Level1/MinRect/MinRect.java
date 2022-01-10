package Programmers.Level1.MinRect;

public class MinRect {
    public int solution(int[][] sizes){
        int answer = 0;
        for(int i=0;i<sizes.length;i++){
            int first = sizes[i][0];
            int second = sizes[i][1];
            if(sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;
            }
        }
        int f_max = -1;
        int s_max = -1;
        for(int i = 0;i<sizes.length;i++){
            if(f_max<sizes[i][0]){
                f_max = sizes[i][0];
            }
            if(s_max<sizes[i][1]){
                s_max = sizes[i][1];
            }
        }

        return s_max * f_max;
    }
}
