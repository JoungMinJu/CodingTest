package Programmers.Level1.Kth;

import java.util.ArrayList;
import java.util.Collections;

public class Kth_again {
    public static int[] solution(int[] array, int[][] commands){
        // i, j, k를 원소로 가진 2차원 배열 commands
        int answer[] = new int[commands.length];

        for(int test=0; test<commands.length; test++){
            ArrayList<Integer> lst = new ArrayList<>();
            for(int i=commands[test][0]-1; i<commands[test][1]; i++)
                lst.add(array[i]);
            Collections.sort(lst);
            answer[test] = lst.get(commands[test][2]-1);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        int[] solution = solution(array, commands);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
