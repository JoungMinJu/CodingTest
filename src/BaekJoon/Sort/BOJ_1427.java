package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        String[] split = input.split("");
        int[] fin = new int[split.length];
        for(int i=0;i<fin.length;i++)
            fin[i] = Integer.parseInt(split[i]);
        Arrays.sort(fin);
        for(int i=fin.length-1; i>=0 ; i--)
            sb.append(fin[i]);
        System.out.println(sb.toString());
    }
}
