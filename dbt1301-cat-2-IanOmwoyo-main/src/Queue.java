public class Queue {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    private Node front;
    private Node rear;
    public Queue(){
        this.front = null;
        this.rear = null;
    }
    public void enqueue(int data){
        Node newNode = new Node(data);
        if(rear == null){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
    }
    public int dequeue(){
        if(front == null){
            System.out.println("Error! Queue is empty");
            return -1;
        }
        int data = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        return data;
    }
    public boolean search(int data){
        Node temp = front;
        while(temp != null){
            if(temp.data == data){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public void traverse(){
        Node temp = front;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    } 
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println("Queue data: ");
        q.traverse();
        System.out.println("Is 40 part of the queue ? " + q.search(40));
        System.out.println("Dequeued data: " + q.dequeue());
        System.out.println("Queue data after dequeue: ");
        q.traverse();
    }
}
