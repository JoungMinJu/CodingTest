package BaekJoon.Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21918 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String 읽기
        String s = br.readLine();
        // 공백 단위로 데이터를 가공하고자 StringTokenizer 사용한다.
        StringTokenizer st = new StringTokenizer(s);
        // N개의 전구
        int N = Integer.parseInt(st.nextToken());
        // M개의 명령
        int M = Integer.parseInt(st.nextToken());

        String[] stat = br.readLine().split(" ");
    }
}
