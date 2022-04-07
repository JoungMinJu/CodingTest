package Algorithm_Two.CH2.binaryTree_prof;

public class BinaryTree {
    public Node root;
    // 생성자
    public BinaryTree(Node root) {
        this.root = root;
    }
    // print node
    public void printNode(){
        System.out.println("전위 순회 시작: ");
        preOrderSerach(root, 0);
        System.out.println("종료");

        System.out.println("중위 순회 시작: ");
        inOrderSearch(root, 0);
        System.out.println("종료");

        System.out.println("후위 순회 시작: ");
        postOrderSearch(root, 0);
        System.out.println("종료");
    }

    // 이진 트리 탐색 연산
    public boolean find(int key){
        Node currentNode = root;
        while(currentNode != null){
            // 현재 노드와 찾는 값이 같으면
            if(currentNode.getData()==key) return true;
            else if(currentNode.getData()>key) currentNode = currentNode.getLeft(); // 찾는값이 더 작으면 왼쪽 트리로 이동
            else currentNode = currentNode.getRight(); // 찾는 값이 더 크면 오른쪽 트리로 이동
        }
        // 못찾으면
        return false;
    }

    // 이진트리 출력 연산
    public void display(Node root){
        if(root!=null){
            // 왼쪽부터 보여주고고
           display(root.getLeft());
           // 나! (각 (서브)트리의 root)
            System.out.print(" "+root.getData());
            display(root.getRight());
        }
    }

    // 이진 트리 삽입 연산
    public boolean insert(int value){
        Node newNode = new Node(value);
        if(find(value)) return false; // 중복 안됨.
        if(root == null) { // root가 null이면 이 노드를 트리의 root로 만들기
            root = newNode;
            System.out.println(root.getData());
            System.out.println("root에 데이터가 들어갔어요");
            return true;}
        Node currentNode = root; // root를 지정해서
        Node parent;
        while(true){
            parent = currentNode;
            if(value<currentNode.getData()) { // value가 더 작은 값이면
                currentNode = currentNode.getLeft();

            }
        }

    }
}
