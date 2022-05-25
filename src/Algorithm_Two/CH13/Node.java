package Algorithm_Two.CH13;
public class Node implements Comparable<Node>{
    int level;  // 노드의 수준
    int weight;	// 선택된 물건들의 총 무게
    int value;	// 선택된 물건들의 총 가치
    int bound;	// 한계값

    public Node() {
        this.level = 0;
        this.weight = 0;
        this.value = 0;
        this.bound = 0;
    }

    // bound(한계값)이 큰 노드가 우선 순위가 높다
    public int compareTo(Node other) {
        // maxheap
        if(bound < other.bound){
            return 1;
        } else if(bound > other.bound){
            return -1;
        } else {
            return 0;
        }
    }
}
