package Algorithm_Two.CH2.binaryTree;

public class BinaryTreeSecondTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        int[] input= {24,16,11,21,32,27};

        for(int i=0;i<input.length;i++){
            binaryTree.insert(input[i]);
        }
//        binaryTree.deleteNode(tree.root,21);
        // 위가 예제코드인데.. 아마 일듯
        binaryTree.delete(binaryTree.root, 21);

        if(binaryTree.find(21)){
            System.out.println("이진트리에서 21찾음");
        }
        else{
            System.out.println("이진트리에서 21 못찾음");
        }

        // 원래는
        // binaryTree.printNode();
        binaryTree.preOrderSearch(binaryTree.root, 4);
    }
}
