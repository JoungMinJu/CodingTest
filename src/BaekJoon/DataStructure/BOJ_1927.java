package BaekJoon.DataStructure;

import javax.crypto.MacSpi;
import javax.swing.text.AbstractWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 최소힙을 이용하여 연산을 지원하는 프로그램
        // 배열에 자연수 x를 넣는다.
        // 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거한다.
        // 연산의 개수 n
        int n = Integer.parseInt(br.readLine());
        // 최소 힙
        minHeap heap = new minHeap();
        for(int i=0;i<n;i++){
            int t= Integer.parseInt(br.readLine());
            if(t==0) System.out.println(heap.delete());
            else{
            heap.insert(t);}
        }
        // 최소 힙 구조르로 만들ㄱ
    }
    // 최소힙 클래스 (참조 : https://go-coding.tistory.com/25)
    static class minHeap{
        private ArrayList<Integer> heap;
        // 생성자
        public minHeap(){
            heap = new ArrayList<>();
            heap.add(0); // 0번째 인덱스는 사용하지 않는다.
        }
        // 삽입
        public void insert(int val){
            heap.add(val);
            int p = heap.size()-1; // 새로 삽입한 노드의 인덱스
            while(p>1 && heap.get(p/2) > heap.get(p)){
                // 새로 삽입한 노드가 부모노드보다 작으면 -> 자리를 바꿔야하는 상황이 됨.
                int tmp = heap.get(p/2);
                heap.set(p/2, val);
                heap.set(p, tmp);

                p = p/2;
            }
        }

        // 출력하고 삭제
        public int delete(){
            // 힙이 비어 있으면 0을 return
            if(heap.size()-1<1) return 0;
            int deleteitem = heap.get(1); // 루트 노드 삭제할 것
            // 마지막 노드를 root에 삽입하고, 마지막 노드 삭제
            heap.set(1, heap.get(heap.size()-1));
            heap.remove(heap.size()-1);

            // 새로 삽입한 노드의 인덱스
            int pos = 1;
            while((pos*2) <heap.size()){
                // 자식 노드가 size()안에 있으면
                int min = heap.get(pos*2); // 왼쪽 자식의 값
                int minPos = pos*2;
                // 오른쪽 자식의 인덱스가 size 보다 작고, 왼쪽보다 더 작을 때 오른쪽 자식을 부모와 바꿔줄 자식으로 지정한다.
                if(((pos*2+1)<heap.size()) && min > heap.get(pos*2+1)) {
                    min = heap.get(pos*2 +1);
                    minPos = pos*2 +1;
                }
                // 여기서 부모가 더 작으면 그만한다.
                if(min > heap.get(pos)) break;
                // 그렇지 않으면 일단 부모랑 자식 교환한다.
                int tmp = heap.get(pos);
                heap.set(pos, heap.get(minPos));
                heap.set(minPos, tmp);
                pos = minPos;
            }
            return deleteitem;
        }
    }
}
