package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1764 {

    static String notHear[];
    static String notSee[];
    static String tmp[];
    static String pair[];

    // 듣도 보도 못한 사라므이 명단 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        // 듣도 못한 사람의 수
        int n = Integer.parseInt(st.nextToken());
        // 보도 못한 사람의 수
        int m = Integer.parseInt(st.nextToken());
        // 돋도 못한 사람 배열
        notHear =new String[n];
        for(int i=0;i<n;i++){
            notHear[i] = br.readLine();
        }
        // 보도 못한 사람 배열
        notSee = new String[m];
        for(int i=0;i<m;i++){
            notSee[i] = br.readLine();
        }
        // 이름은 띄어쓰기 없이 소문자로만 이루어진다.

        Arrays.sort(notHear);
        Arrays.sort(notSee);

        tmp = (notHear.length > notSee.length)?notSee:notHear;
        pair = (notHear.length > notSee.length)?notHear:notSee;
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<tmp.length;i++){
            if(binarySearch(tmp[i],0,pair.length-1)){
                ans.add(tmp[i]);
            }
        }
        System.out.println(ans.size());
        for (String an : ans) {
            System.out.println(an);
        }

    }

    private static boolean binarySearch(String target, int low, int high) {
//        System.out.println("target = " + target);
        int mid = (low+high)/2;
//        System.out.println(pair[mid]);
//        System.out.println("low = " + low);
//        System.out.println("mid = " + mid);
//        System.out.println("high = " + high);
//        System.out.println();
        if(low > high) {return false;}
        else{
            if(target.equals(pair[mid])) {
//                System.out.println("찾았다");
                return true;}
            // 좌측값이 큰 경우
            else if(target.compareTo(pair[mid])>=1){
//                System.out.println("target이 더 크다");
                low=mid+1;
                return binarySearch(target,low, high);}
            // 우측값이 큰 경우
            else if(target.compareTo(pair[mid]) <= -1) {
//                System.out.println("target이 더 작다");
                high = mid-1;
                return binarySearch(target,low, high);}
        }
        return false;
        }

    }


