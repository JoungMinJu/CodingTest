package Algorithm_Two.CH2.binaryTree_prof;

public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        int[] input = {5,2,1,3,4,7,6,8};

        // 이진 트리 노드 삽입
        for (int i : input) {
            tree.insert(i);
        }

        // 이진 트리 출력
        tree.display(tree.root);

        // 이진 트리 순회 출려
        tree.printNode();;

        // 이진 트리 노드 삭제
        tree.deleteBT(4); // 자식 없는 경우
        tree.deleteBT(3); // 자식 하나 있는 경우
        tree.deleteBT(7); // 자식 둘 있는 경우

        if(tree.find(6)) System.out.println(" 이진트리에서 6 찾음!");
        else System.out.println("이진 트리에서 6 못찾음!");

        // 삭제 후 이진트리 출력
        tree.display(tree.root);
    }
}
