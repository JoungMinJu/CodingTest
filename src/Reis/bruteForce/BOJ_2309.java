package Reis.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int exceptIndex1 = -1, exceptIndex2 = -1;
        List<Integer> answer = new ArrayList<>();
        int[] heights = new int[9];

        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (isRight(i, j, heights)) {
                    exceptIndex1 = i;
                    exceptIndex2 = j;
                    break;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if( i != exceptIndex1 && i != exceptIndex2){
                answer.add(heights[i]);
            }
        }

        Collections.sort(answer);

        for (int height : answer) {
            System.out.println(height);
        }
    }

    private static boolean isRight(int index1, int index2, int[] heights) {
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i != index1 && i != index2) {
                sum += heights[i];
            }
        }

        return sum == 100;
    }
}
