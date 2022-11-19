package ssafy.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            String encoded = br.readLine();
            String decoded = new String(Base64.getDecoder().decode(encoded));
            sb.append("#").append(testCase).append(" ").append(decoded).append("\n");
        }
        System.out.println(sb.toString());
    }
}