package Doit.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BOJ_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>(); // value, 기존 index
        List<Integer> lst = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            map.put(arr[i], i);
        }

        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            int now = map.get(arr[i]) - i; // 정렬전 index - 정렬 후 index
            if(now>max)
                max = now;
        }
        System.out.println(max+1);
    }

    // 해당 코드는 input 5 1 1 1 1 1 에서 틀림 ! 정상 답은 1
    // 아마 sort에서 문제가 되지 않았나
}
