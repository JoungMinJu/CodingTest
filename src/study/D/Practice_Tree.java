package study.D;

public class Practice_Tree {
    class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
        }
    }

    public Node root;

    public void createNode(int data, int left, int right){
        if(root == null) {
            root = new Node(data);
            if(left != -1 ) root.left = new Node(left);
            if(right != -1) root.right = new Node(right);
        }
        else {
            searchNode(root, data, left, right);
        }
    }

    public void searchNode(Node node, int data, int left, int right){
        if(node == null) return;
        else if( node.data == data){
            if(left != -1)  node.left = new Node(left);
            if(right != -1) node.right = new Node(right);
        }
        else{
            searchNode(node.right, data, left, right);
            searchNode(node.left, data, left, right);
        }
    }

    public void preorder(Node node){
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(Node node){
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    public void postorder(Node node){
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }
}
