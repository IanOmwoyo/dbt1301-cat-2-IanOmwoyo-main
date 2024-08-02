public class LinkedList {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    public LinkedList(){
        head = null;
    }
    public void insertBeginning(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } else{
            newNode.next = head;
            head = newNode;
        }
    }
    public void insertEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else {
            Node last = head;
            while (last.next != null){
                last = last.next;
            }
            last.next = newNode;
        }
    }
    public void delete(int key){
        if(head == null) return;
        if(head.data == key){
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null){
            if(temp.next.data == key){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
    public boolean searchNode(int key){
        Node temp = head;
        while (temp != null){
            if(temp.data == key){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public void printTheList(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public class Main{
        public static void main(String[] args) {
            LinkedList list = new LinkedList();
            list.insertEnd(10);
            list.insertBeginning(20);
            System.out.println("Linked List Result: ");
            list.printTheList();
            System.out.println("10 in the list ? " + list.searchNode(10));
            list.delete(10);
            System.out.println("Linked List Result after deletion: ");
            list.printTheList();
        }
    }
}