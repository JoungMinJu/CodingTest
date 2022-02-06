package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

public class BOJ_1755{
    static String[] eng = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<String> lst = new ArrayList<>();
        for(int i=m;i<=n;i++){
            String temp = "";
            if(i>=10){
                temp += toString(i/10);
                temp += " ";
            }
            temp += toString(i%10);
            lst.add(temp);
        }
        Collections.sort(lst);
        StringBuilder sb = new StringBuilder();
        // 문자열을 더할때 기존의 데이터에 더하는 방식을 사용하는 StringBuilder
        int cnt = 0;

        for(int i=0;i<lst.size();i++){
            String str = lst.get(i);
            String s[] = str.split(" ");
            int num=0;
            if(s.length>1){
                num += 10* toInt(s[0]);
                num+=toInt(s[1]);
            }
            else {
                num+=toInt(s[0]);
            }
            sb.append(num+ " ");
            cnt ++;
            if(cnt%10==0) sb.append("\n");
        }
        System.out.println(sb);

    }
    public static String toString(int i){
        return eng[i];
    }
    public static int toInt(String s){
        return Arrays.asList(eng).indexOf(s);
    }
}