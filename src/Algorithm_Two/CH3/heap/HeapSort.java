package Algorithm_Two.CH3.heap;

public class HeapSort {
    public static void main(String[] args) {
        int intArray[]={0,1,2,6,4,8,7};
        int i;
        //정렬하기 전 배열 출력
        System.out.print("정렬 전 배열: ");

        for(i=1;i<intArray.length;i++){
            System.out.print(intArray[i]+" ");
        }
        // 힙정렬을 사용하여 정려라기 위해 heapSort 메소드를 호출한다.
        heapSort(intArray);

        // 정렬한 후 배열 출력
        System.out.print("\n 정렬 후 배열: ");

        for(i=1;i<intArray.length;i++){
            System.out.print(intArray[i]+" ");
        }
    }
    // 힙 정렬
    public  static void heapSort(int[] A){
        int eh, tmp;
        eh = A.length-1;

        // 주어진 배열 힙으로 만ㄷ르기
        buildHeap(A, eh);
        // 힙에서 최댓값을 제거하고 남은 트리를 다시 힙으로 만들기
        while(eh>1){
            //A[1]과 A[eh]를 교환
            tmp = A[1];
            A[1] = A[eh];
            A[eh]=tmp;

            // 힙에서 최댓값 제거
            eh = eh-1;

            //남은 트리 다시 힙으로 만들기
            pushDown(A, 1, eh/2, eh);
        }
    }

    // 배열 [1,~, eh]를 힙으로 만ㄷ르기
    public static void buildHeap(int[] A, int eh){
        int bh, x;
        bh = (A.length-1)/2+1;
        while(bh>1){
            bh = bh-1;
            x= bh;

            //x에서 힙조건이 만족될 떄까지 A[x]를 트리의 아래층으로 내려봰다.
            pushDown(A, x, bh,eh);
        }
    }
    // 트리의 아래층으로 내려보낸다.
    public static void pushDown(int[] A, int x, int bh, int eh) {
        int y,tmp;
        y= findLarge(A, x,eh);
        while(A[x]<A[y]){
            tmp = A[x];
            A[x] = A[y];
            A[y] = tmp;

            x=y;

            y=findLarge(A,x,eh);
        }
    }

    // 더 큰값을 가지는 x의 자식 노드의 지수 구하기
    public static int findLarge(int[] A, int x, int eh){
        int y=0;

        if(2*x+1<=eh){
            // 자식노드가 둘 다 있는경우
            if(A[2*x] > A[x] || A[2*x+1]>A[x]){
                //A[x]보다 더 큰 값을 가지는 자식노드의 지수를 구한다.
                if(A[2*x] >=A[2*x+1]) y=2*x;
                else y=2*x+1;
            }
        }else{
            // 자식 노드가 하나만 이쓰면
            if(2*x<=eh&&A[2*x] > A[x]) y=2*x;
        }
        return y;
    }

}
