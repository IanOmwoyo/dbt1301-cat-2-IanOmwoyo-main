public class BinarySearchTree {
    class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    Node root;
    public BinarySearchTree(){
        this.root = null;
    }
    public void insert(int data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
        }else{
            insertNode(root, newNode);
        }
    }
    private void insertNode(Node currentNode, Node newNode){
        if(newNode.data < currentNode.data){
            if(currentNode.left == null){
                currentNode.left = newNode;
            }else{
                insertNode(currentNode.left, newNode);
            }
        } else if(newNode.data > currentNode.data){
            if(currentNode.right == null){
                currentNode.right = newNode;
            } else{
                insertNode(currentNode.right, newNode);
            }
        }
    }
    public void delete(int data){
        root = deleteNode(root, data);
    }
    private Node deleteNode(Node currentNode, int data){
        if(currentNode == null){
            return currentNode;
        }
        if(data < currentNode.data){
            currentNode.left = deleteNode(currentNode.left, data);
        } else if(data > currentNode.data){
            currentNode.right = deleteNode(currentNode.right, data);
        } else {
            if(currentNode.left == null && currentNode.right == null){
                return null;
            }
            else if(currentNode.left == null){
                return currentNode.right;
            }else if(currentNode.right == null){
                return currentNode.left;
            }
            else{
                Node temp = findMinimum(currentNode.right);
                currentNode.data = temp.data;
                currentNode.right = deleteNode(currentNode.right, temp.data);
            }
        }
        return currentNode;
    }
    private Node findMinimum(Node currentNode){
        while(currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode;
    }
    public boolean search(int data){
        return searchNode(root, data);
    }
    private boolean searchNode(Node currentNode, int data){
        if(currentNode == null){
            return false;
        }
        if(data < currentNode.data){
            return searchNode(currentNode.left, data);
        }else if(data > currentNode.data){
            return searchNode(currentNode.right, data);
        }else{
            return true;
        }
    }
    public void orderTrav(){
        orderTrav(root);
    }
    private void orderTrav(Node currentNode){
        if(currentNode != null){
            orderTrav(currentNode.left);
            System.out.print(currentNode.data + " ");
            orderTrav(currentNode.right);
        }
    }
    public void preorderTrav(){
        preorderTrav(root);
    }
    public void preorderTrav(Node currentNode){
        if(currentNode != null){
            System.out.print(currentNode.data + " ");
            preorderTrav(currentNode.left);
            preorderTrav(currentNode.right);
        }
    }
    public void postorderTrav(){
        postorderTrav(root);
    }
    private void postorderTrav(Node currentNode){
        if(currentNode != null){
            postorderTrav(currentNode.left);
            postorderTrav(currentNode.right);
            System.out.print(currentNode.data + " ");
        }
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(8);
        tree.insert(3);
        tree.insert(10);
        tree.insert(1);
        tree.insert(6);
        System.out.println("Binary Search Tree Data: ");
        tree.orderTrav();
        System.out.println("\nPreorder Traversal: ");
        tree.preorderTrav();
        System.out.println("\nPostorder Traversal: ");
        tree.postorderTrav();
    }
}