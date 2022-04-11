package Algorithm_Two.CH3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MinHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        minHeap heap = new minHeap();
        for(int i=0;i<n;i++){
            int val = Integer.parseInt(br.readLine());
            if(val ==  0) System.out.println(heap.delete());
            else heap.insert(val);
        }
        System.out.println("결과 출력");
        ArrayList<Integer> heap1 = heap.getHeap();
        System.out.println("heap1 = " + heap1);
    }

    public static class minHeap{
        // 배열 선언
        private ArrayList<Integer> heap;

        public ArrayList<Integer> getHeap() {
            return heap;
        }

        // 힙 생성자
        public minHeap(){
            heap = new ArrayList<>();
            heap.add(0); // 인덱스 0 채우기
        }
        // 삽입
        public void insert(int val){
            // 젤 끝에 앉히고
            heap.add(val);
            // 젤 끝의 index p에 넣는다.
            int p = heap.size()-1;
            // 힙 사이즈-1이 1보다 작아질 때까지 진행. => root로 이동한다는의미
            // 젤 끝의 인덱스가 root가 아니고
            // 부모 노드가  자식노드보다 크면(?) --> 오름차순 구현이 목표!
            while(p>1 && heap.get(p/2)>heap.get(p)){
                System.out.println("swap");
                int temp = heap.get(p/2);
                heap.set(p/2, heap.get(p));
                heap.set(p,temp);
                p/=2;
            }
        }
        // 삭제
        public int delete(){
            if(heap.size()-1<1) return 0;
            // 삭제할 노드는 루트 노드
            int deleteItem = heap.get(1);
            // root에 가장 마지막 값 넣고, 가장 마지막 값 삭제
            heap.set(1, heap.get(heap.size()-1));
            heap.remove(heap.size()-1);

            int pos = 1;

            while((pos*2)<heap.size()) {
                int min = heap.get(pos*2);
                int minPos = pos*2;

                if(((pos*2+1)<heap.size()) && min>heap.get(pos*2+1)) {
                    min = heap.get(pos*2+1);
                    minPos = pos*2+1;
                }
                // 자식 노드 둘 중에서 더 작은애 찾음

                // 부모가 더 작으면 (= 맞게 들어왔으면 break)
                if(heap.get(pos)<min) break;

                // 그렇지 않다면
                //부모 자식 노드 교환
                int temp = heap.get(pos);
                heap.set(pos, heap.get(minPos));
                heap.set(minPos, temp);
                pos = minPos;
            }
            return deleteItem;
            }
        }
    }

