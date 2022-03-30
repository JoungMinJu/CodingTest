package Algorithm_Two.CH2.binaryTree;

public class BInaryTreetest {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(5);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(7);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        if(tree.find(6)) System.out.println("1. 이진트리에서 6 찾음 !!");
        else System.out.println("1. 이진트리에서 6 못찾음 !!");
    }
}
