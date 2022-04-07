package BaekJoon.Binary;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2776_adv {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<Integer> hs = new HashSet<>();

        int testCase = Integer.parseInt(br.readLine());
        for(int i=0;i<testCase;i++){
            hs.clear();
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<num;j++){
                hs.add(Integer.parseInt(st.nextToken()));
            }

            num = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<num;j++){
                if(hs.contains(Integer.parseInt(st.nextToken()))){
                    bw.write(String.valueOf(1)+"\n");
                }
                else{
                    bw.write(String.valueOf(0)+"\n");
                }
            }
            bw.flush();
        }
        bw.close();

    }
}
