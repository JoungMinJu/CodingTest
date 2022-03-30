package Algorithm_Two.CH2.binaryTree;

import Algorithm_Two.CH2.Node;

public class BinaryTree {
    Node root;
    // 생성자에서 root를 받을 수 있어야한다.

    public BinaryTree() {
        this.root = null;
    }
    //find
    boolean find(int value){
        Node currentNode =root;
        while(currentNode!=null){
            if(currentNode.getValue()==value){ return true;}
            else if(currentNode.getValue() > value){
                // 찾으려는 값이 현재 노드보다 작으면
                currentNode = currentNode.getLeft();
            }
            else{ // 찾으려는 값이 현재 노드보다 크면
                currentNode = currentNode.getRight();

            }
        }
        return false;
    }
    // insert
    public boolean insert(int value){
        Node node = new Node(value);
        if(find(value)){
            // 같으 키의 값을 갖는 노드는 존재하지 않는다는 전제조건
            return false;}
        if(root == null){
            //root가 null이면 new Node를 root로 변경하고 return한다.
            root = node;
            return true;
        }
        Node currentNode =root;
        Node parent;

        while(true){
            parent =  currentNode;
            if(value< currentNode.getValue()){
                currentNode = currentNode.getLeft();
                if(currentNode==null){
                    parent.setLeft(node);
                    return true;
                }
            }else{
                currentNode = currentNode.getRight();
                if(currentNode==null){
                    parent.setRight(node);
                    return true;
                }
            }
        }
    }

    // 노드 삭제
    // ppt에는 public Node deleteNode(~,~)인데.. 테스트에선 아님
    public Node delete(Node root, int key){
        if(root==null) return root;

        if(key<root.getValue()){
            // 키가 루트보다 작다면 왼쪽 서브트리에 있는 것
            root.setLeft(delete(root.getLeft(), key));
        }
        else if(key>root.getValue()){
            //키가 루트보다 크다면 오른쪽 서브트리에 있는 것
            root.setRight(delete(root.getRight(), key));
        }
        else{
            // 키와 루트가 같다면 이 노드가 바로 삭제할 노드
            if(root.getLeft()==null){
                // 1. 단말 노드이거나 2. 하나의 서브트리만 있는 경우
                // null값이면 null 반환, 오른쪽 있으면 오른쪽 반환해서 이전의if else if에서의 왼쪽이든 오른쪽 노드에 붙여주는 것
                return root.getRight();
            }
            else if(root.getRight()==null){
                return root.getLeft();
            }
            // 3. 두개의 서브트리가 있는 경우!
            Node temp = minValueNode(root.getRight());
            //오른쪽 서브 트리에서 가장 작은 값이 후계노드

            root.setValue( temp.getValue());
            //후계 노드값 복사 (삭제할 노드의 값을 후계 노드로 변경
            root.setRight(delete(root.getRight(), temp.getValue()));
            // 후계 노드 삭제!
        }
        return root;
    }

    private Node minValueNode(Node node) {
        Node currentNode = node;
        while(currentNode.getLeft()!=null){
            currentNode= currentNode.getLeft();
        }
        return currentNode;
    }

    // 트리 탐색하기

    // 전위 순회 root->left->right
    public  void preOrderSearch(Node node, int depth){
        if(node!=null){
            System.out.print(node.getValue()+" -> ");
            preOrderSearch(node.getLeft(), depth+1);
            preOrderSearch(node.getRight(), depth+1);
        }
    }

    // 중위순회 오름차순 정렬 = left->root->right
    // 이름 바꾸기 ㅠ
    public void preOrderSearch2(Node node, int depth){
        if(node!=null){
            System.out.print(node.getValue()+" -> ");
            preOrderSearch2(node.getLeft(), depth+1);
            preOrderSearch2(node.getRight(), depth+1);
        }
    }

    // 후위순회 left->right->root
    public void postOrderSearch(Node node, int depth){
        if(node!=null){
            postOrderSearch(node.getLeft(), depth+1);
            postOrderSearch(node.getRight(), depth+1);
            System.out.print(node.getValue()+" -> ");
        }
    }



}
