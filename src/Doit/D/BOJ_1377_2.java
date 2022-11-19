package Doit.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1377_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Data[] arr = new Data[n];

        for(int i=0; i<n; i++){
            arr[i] = new Data(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arr);

        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(max<arr[i].index - i){
                max = arr[i].index -i;
            }
        }

        System.out.println(max+1);
    }

    static class Data implements Comparable<Data>{
        int value, index;

        public Data(int value, int index){
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Data o) {
            return this.value - o.value; // value 기준 오름차순 정렬
        }
    }
}
