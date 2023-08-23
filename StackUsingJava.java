public class StackUsingJava {
    private int top;
    private int data[];
    public StackUsingJava(){
        data= new int[10];
        top=-1;
        System.out.print("Stack is created");
    }
    public StackUsingJava(int capacity){
       data= new int[capacity];
        top=-1;
    }
    public boolean isEmpty(){
        if(top==-1) return true;
        else return false;
    }
    public int top(){
        if(top==-1) {
            System.out.println("***Empty***");
            return 0;
        }
        else{
            return data[top];       
         }
    }
    public int size(){
        return top+1;
    }
    public void push(int ele){
        if(size()==data.length){
            doublecap();
        }
        top++;
        data[top]=ele;
    }
    public void doublecap(){
        int temp[] =data;
        data= new int[2*data.length];
        for(int i=0;i<temp.length;i++){
            data[i]=temp[i];
        }
    }
    public int pop(){
        if(top==-1){
            System.out.print("Empty Stack "+" ");
            return -1;
        }
        else{
        int ele=data[top];
        top--;
        return ele;
        }
    }
    public static void main(String []args){
           StackUsingJava stack1 = new StackUsingJava();
        
           stack1.push(10);
           System.out.println(stack1.pop());
           System.out.println(stack1.size());
           stack1.push(5); stack1.push(5); stack1.push(3); stack1.push(17); stack1.push(10);
           stack1.push(10);  stack1.push(10); stack1.push(10); stack1.push(1);
           System.out.println(stack1.size());
           System.out.println(stack1.top());
           System.out.println(stack1.isEmpty());

            }
           

}
