package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> s = new HashSet<>();
        for(int i=0;i<n;i++){
            arr.add(Integer.parseInt(st.nextToken()));
            // tmp도 arraylist로 하고 index 찾고 삭제해버리면 되겠다.
            tmp.add(arr.get(i));
            s.add(arr.get(i));
        }

        // 정렬하기
        ArrayList<Integer> list = new ArrayList<>(s);
        Collections.sort(list);
        //999, 1000으로 list 배열 정렬

        Set<Integer> indexSet;
        // 큰애부터 꺼냄
        for(int i=list.size()-1;i>=0;i--){
            // t = 1000
            int t = list.get(i);

            // 1000의 모든 인덱스 추출
            indexSet = new HashSet<Integer>();
            // tmp에서 1000에 해당하는 index추출
            int index;
            int start=0;
            while(true){
                index = tmp.subList(start, tmp.size()).indexOf((Integer)t);
                System.out.println("t = " + t);
                System.out.println("index = " + index);
                if(index>=tmp.size()) break;
                if(index == -1) break;
                if(!indexSet.contains((Integer) index)) {indexSet.add(index); start=index+1;}
                System.out.println("start = " + start);
                }

            // 추출한 index에 값 넣어주기
            list.remove((Integer) t);
            for (Integer integer : indexSet) {
                arr.set(integer, list.size());
            }
        }

        for (Integer integer : arr) {
            System.out.println("integer = " + integer);
        }

    }
}
