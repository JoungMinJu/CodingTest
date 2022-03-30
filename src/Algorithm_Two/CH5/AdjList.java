package Algorithm_Two.CH5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AdjList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // vertex 개수
        int vCnt = Integer.parseInt(sc.next());
        // edge 개수
        int eCnt = Integer.parseInt(sc.next());

        ArrayList<ArrayList<Integer>> addList = new ArrayList<>();

        // 리스트 인덱스 '1'로 하기에, dummy data로 한 개 넣어놓는다.
        addList.add(new <Integer>ArrayList());

        for(int i=0;i<vCnt;i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            addList.get(v1).add(v2);
        }

        // 인접 리스트 출력
        for(int i=1;i<vCnt;i++){
            Iterator<Integer> iter = addList.get(i).iterator();
            System.out.print("["+i+"]: ");
            while(iter.hasNext()){
                System.out.print(iter.next()+" ");
            }
            System.out.println();
        }
    }
}
