package Algorithm_Two.CH3;

public class HeapSort {
    public static void main(String[] args) {
        int[] Array = {0,1,2,6,4,8,7};

        // 정렬하기 전 배열
        System.out.println("정렬 전 배열");
        for (int i : Array) {
            System.out.print(i+" ");
        }

        // 힙 정렬 사용하여 정렬하기 위해 메소드 호출
        heapSort(Array);

        // 정렬 후 배열
        System.out.println("정렬 후 배열");
        for (int i : Array) {
            System.out.print(i+" ");
        }
    }

    // 힙 정렬하기
    public static void heapSort(int[] A){
        int eh, temp;
        // 힙의 마지막 노드의 지수 eh(0부터 시작하니까 -1 해준다.)
        eh = A.length -1;

        //주어진 배열 힙으로 만들기 (단계 1)
        buildHeap(A, eh);

        // 힙에서 최댓값을 제거하고 남은 트리를 다시 힙으로 만든다.
        while(eh>1){
            // A[1]은 최댓값
            temp =A[1];
            A[1] = A[eh];
            A[eh] = temp;

            // 힙에서 최댓값을 제거
            eh -=1;

            // 남은 트리를 다시 힙으로 만든다.
            // 마지막 노드 지수는 eh에서 하나 뺀다!!!!!!!!!!!!!!!!!!!!!!!
            // eh/2는 bh를 대체하는데, 이때 bh는 자식 있는 힙의 내부 노드
            pushDown(A, 1,eh/2, eh);
        }
    }

    private static void buildHeap(int[] A, int eh) {
        int bh, x;
        // 힙 조건을 확인 중이 노드의 지수
        bh = (A.length-1)/2+1;
        //  = eh/2+1;  힙 내의 첫 번쨰 잎(=말단 노드)의 지수
        while(bh>1){
            // 그 위로 올라온다. (자식 잇는 힙의 내부 노드 지정)
            // 왜냐면 처음에 힙을 만드는 과정은, 힙 내부의 노드부터 검사해가면서 하나씩 위로 올라오기 때문에!
            bh = bh-1;
            x = bh;
            // x에서 힙 조건이 만족될 때까지 A[X}를 트리 아래층으로 내려보낸다.
            // 왜냐면 x는 자식이 있는 넘이니까.
            pushDown(A, x, bh,eh);
        }
    }

    private static void pushDown(int[] A, int x, int bh, int eh) {
        int y, temp;
        // A[x]보다 큰 값을 가지는 x의 자식 노드의 지수 구함
        // bh가 웨 필요함..?
        y= findLarge(A,x,eh);
        while(A[x]<A[y]){
            temp = A[x];
            A[x] = A[y];
            A[y] = temp;

            x=y;
            // 혹시바꿨는데 그 아래에 자식이  더 크다면~..
            y= findLarge(A,x,eh);
        }
    }

    private static int findLarge(int[] A, int x, int eh) {
        // A[x]보다 큰 값을 가지는 x의 자식 노드의지수 구하기
        int y=0;
        // 굳이 eh 안해도될것 같은데.. eh= A.length-1;
        if(2*x+1<=eh){
            // 자식 노드가 둘 다 있다면
            if(A[2*x]>A[x] || A[2*x+1]>A[x]){
                y = (A[2*x]>=A[2*x+1])?(2*x):(2*x+1);
            }
        }
        // 자식 노드가 하나만 있다면
        else{
            if(2*x<=eh && A[2*x] > A[x]) y = 2*x;
        }
        return y;
    }
}
