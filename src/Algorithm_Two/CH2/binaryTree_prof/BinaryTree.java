package Algorithm_Two.CH2.binaryTree_prof;

public class BinaryTree {
    public Node root;
    // 생성자
    BinaryTree() {root=null;}
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
                System.out.println(value);
                System.out.println("left에 데이터가 들어갔습니다.");
                if(currentNode==null){
                    parent.setLeft(newNode);
                    return true;
                }
            }else{
                currentNode = currentNode.getRight();
                System.out.println(value);
                System.out.println("right에 데이터가 들어갔습니다.");
                if(currentNode==null){
                    parent.setRight(newNode);
                    return true;
                }
            }
        }

        }
    // 특정 노드 삭제
    //  current - 삭제 노드
    //  parent -  삭제 노드의 부모 노드
    //  isLeftChild - 삭제 노드의 왼쪽 자식 노드
    // 다른 버전도 구현해보기
    public boolean deleteBT(int id){
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        // 해당 데이터 가지는 노드 찾기
        while(current.getData()!=id){
            parent = current;
            if(current.getData() > id){
                isLeftChild = true;
                current = current.getLeft();
            }
            else {
                isLeftChild = false;
                current = current.getRight();
            }
            if(current==null) return false;
        }
        //System.out.println("current: "+current.getData());
        //System.out.println("parent : "+parent.getData());
        //System.out.println("current Left : "+current.getLeft());
        //System.out.println("current Right : "+current.getRight());

        // 케이스1 : 자식노드가 없는 경우
        if(current.getLeft()==null && current.getRight()==null){
            if(current == root ) root= null;
            if(isLeftChild) {
                parent.setLeft(null);
                System.out.println("nochild left delete!");
            }else{
                parent.setRight(null);
                System.out.println("nochild right delete!");
            }
        }

        // 케이스2 : 하나의 자식을 갖는 경우
        else if(current.getRight()==null){
            if(current == root) root =current.getLeft();
            else if(isLeftChild) parent.setLeft(current.getLeft());
            else parent.setRight(current.getLeft());
        }
        else if(current.getLeft()==null){
            if(current==root) root=current.getRight();
            else if(isLeftChild) parent.setLeft(current.getRight());
            else parent.setRight(current.getRight());
        }

        // 케이스3 : 두 개의 자식을 갖는 경우
        else if(current.getLeft()!=null && current.getRight()!=null){
            // 삭제할 노드의 서브트리의 값 a 혹은 b를 찾음
            Node successor = getSuccessor(current);
            // 케이스 3 : 두개의 자식을 갖는 경우 -> 자식 노드 중에서 삭제할 노드보다 작으면서 가장 큰 값 사제
            // Node successor = getSuccessorV2(current);
            if(current == root) root = successor;
            else if(isLeftChild) parent.setLeft(successor);
            else parent.setRight(successor);
            successor.setLeft(current.getLeft());
            // successor.setRight(current.getRight());
        }
        return true;
    }

    public Node getSuccessor(Node deleteNode){
        Node successor  = null;
        Node successorParent = null;
        Node current = deleteNode.getRight();
        // 오른쪽 서브 트리의 최솟값을 찾는다
        while(current!=null){
            successorParent = successor;
            successor=current;
            current = current.getLeft();
        }
        if(successor!=deleteNode.getRight()){
            successorParent.setLeft(successor.getRight());
            successor.setRight(deleteNode.getRight());
        }
        return successor;
    }

    // 자식 노드 중에서 작으면서 가장 큰 값
    // 맞는지 확인하기
    // https://withhamit.tistory.com/450
    public Node getSuccessorV2(Node deleteNode){
        Node successor = null;
        Node successorParent = null;
        Node current  = deleteNode.getLeft();
        // 왼쪽 서브트리의 최댓값을 찾는다
        while(current!=null){
            successorParent = successor;
            successor = current;
            current = current.getRight();
        }
        if(successor!=deleteNode.getLeft()){
            //오른쪽 자식이 없을 때까지 내려오다가
            // 내가 가진 작은 값을 내위치에 가져다오고
            successorParent.setRight(successor.getLeft());
            successor.setLeft(deleteNode.getLeft());
        }
        return successor;
    }

    // 중위 순회
    public void inOrderSearch(Node node, int depth){
        if(node !=null){
            inOrderSearch(node.getLeft(), depth+1);
            System.out.print(node.getData()+" -> ");
            inOrderSearch(node.getRight(), depth+1);
        }
    }

    // 후위 순회
    public void postOrderSearch(Node node, int depth){
        if(node!=null){
            postOrderSearch(node.getLeft(), depth+1);
            postOrderSearch(node.getRight(), depth+1);
            System.out.print(node.getData()+" -> ");
        }
    }

    // 전위 순회
    public void preOrderSerach(Node node, int depth){
        if(node!=null){
            System.out.print(node.getData()+" -> ");
            preOrderSerach(node.getLeft(), depth+1);
            preOrderSerach(node.getRight(), depth+1);
        }
    }


}
