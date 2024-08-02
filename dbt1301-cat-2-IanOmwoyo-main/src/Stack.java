public class Stack {
    private int maximumSize;
    private int top;
    private int[] stackArray;
    public Stack(int size){
        maximumSize = size;
        stackArray = new int[maximumSize];
        top = -1;
    }
    public void push(int value){
        if(top < maximumSize - 1){
            stackArray[++top] = value;
        }else{
            System.out.println("Stack is full");
        }
    }
    public int pop(){
        if(top >= 0){
            return stackArray[top--];
        }else{
            System.out.println("Error! Stack is empty");
            return -1;
        }
    }
    public boolean search(int value){
        for(int i = 0; i <= top; i++){
            if(stackArray[i] == value){
                return true;
            }
        }
        return false;
    }
    public void traverse(){
        for(int i = 0; i <= top; i++){
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack data: ");
        stack.traverse();
        System.out.println("Pop data: " + stack.pop());
        System.out.println("Stack data after pop: ");
        stack.traverse();
    }
}
