package Algorithm_Two.CH3.heap_prof;

public class HeapSort {
    public static void main(String[] args) {
        int[] intArray={0,8,4,7,1,2,6};

        // 정렬하기 전 배열 출력
        System.out.print("정렬 전 배열 : ");

        for (int i1 : intArray) {
            System.out.print(i1+" ");
        }

        // 힙 정렬을 사용하여 정렬하기 위해서 headSort 메소드를 호출
        heapSort(intArray);

        // 정렬한 후 배열을 출력한다.
        System.out.print("\n정렬 후 배열 : ");
        for (int i1 : intArray) {
            System.out.print(i1 +" ");
        }
    }

    // 힙 정렬
    private static void heapSort(int[] A) {
        int eh, temp;
        // 마지막에 들어있는 인수 eh
        eh = A.length-1;
        // 주어진 배열 힙으로 만들기
        buildHeap(A, eh);

        // 힙에서 최대값을 제거하고 남은 트리를 다시 힙으로 만든다.
        while(eh>1){
            // 교환
            temp = A[1];
            A[1] = A[eh];
            A[eh] = temp;
            System.out.print(" temp : ("+temp+")");
            // 힙에서 최댓값을 제거한다.
            eh  -=1;

            // 남은 트리를 다시 힙으로 만든다.
            pushDown(A, 1, eh/2, eh);

            System.out.print(" eh : ("+eh+")");
            for (int i : A) {
                System.out.print(i+ " ");
            }

    }}

    // 배열 A[1..eh]를 힙으로 만들기
    private static void buildHeap(int[] A, int eh) {
        int bh, x;
        //  A.length-1의 부모노드?
        bh= (A.length-1)/2+1;
        while(bh>1){
            bh = bh -1;
            x = bh;
            // x에서 힙 조건이 만족될때까지 A[x]를 트리의 아래 층으로 내려 보낸다.
            pushDown(A, x, bh, eh);


            }
        }


    private static void pushDown(int[] A, int x, int bh, int eh) {
        int y, temp;
        y = findLarge(A,x,eh);
        while(A[x]<A[y]){
            temp = A[x];
            A[x] = A[y];
            A[y]= temp;
            x = y;
            y= findLarge(A, x, eh);
        }
    }
    // A[x] 보다 더 큰 값을 가지는 X의 자식 노드의 지수를 구한다.
    private static int findLarge(int[] A, int x, int eh) {
        int y = 0;
        if(2*x+1<=eh){
            // 자식 노드가 둘 다 있는 경우
            if(A[2*x] >A[x]||A[2*x+1]>A[x]){
                if(A[2*x] >= A[2*x+1]) y = 2*x;
                else y=2*x+1;
            }}else{
                // 자식 노드가 하나만 있는 경우
                if(2*x <= eh && A[2*x] > A[x]) y = 2*x;
            }
            return y;

    }
}
