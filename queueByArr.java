public class queueByArr {
    private int data[];
    private int front;
    private int rear;

    public queueByArr(){
        data = new int[3];
        front =-1;
        rear=-1;
    }

    public queueByArr(int cap){
        data = new int[cap];
        front =-1;
        rear=-1;
    }

    public boolean isEmpty(){
        if(front==-1 && rear==-1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isFull(){
        if((rear==data.length-1 && front==0) || (front==rear+1)) {
            return true;
        }
        else{
           return false;
        }
    }

    public int size(){
        if(isEmpty()) return 0;
        else return front;
    }
    public void doublecapacity(){
        int temp[] = data;
        int index=0;
        data=new int[2*data.length];
        for(int i=front;i<temp.length;i++){
            data[index]=temp[i];
            index++;
        }
        for(int i=0;i<=front-1;i++){
            data[index]=temp[i];
            index++;
        }
        front=0;
        rear=temp.length-1;
    }
    public void enqueue(int ele){
      
        if(isFull()){
            doublecapacity();
        }

        if(isEmpty()){
            front=0;
        }
        
        
        
         rear=(rear+1)%data.length;
            data[rear]=ele;
        
    }

    public int Dequeue(){
        
        if(isEmpty()) return -1;
       
        int item = data[front];
        if(front==rear){
            front=-1;
            rear=-1;
        }
        else
        front=(front+1)%data.length;
        return item;
    }

    public static void main(String args[]){
        queueByArr q1=new queueByArr();
        q1.enqueue(5);
        q1.enqueue(6);
        System.out.println(q1.Dequeue()); 
        q1.enqueue(7);
        q1.enqueue(8);
        q1.enqueue(9);
        q1.enqueue(10);
        System.out.println(q1.Dequeue()); 
        System.out.println(q1.Dequeue());
        System.out.println(q1.Dequeue()); 
        System.out.println(q1.Dequeue()); 
        System.out.println(q1.Dequeue());
        System.out.println(q1.Dequeue());
        
        System.out.println("size=>" + q1.size()); 
       
    }
}
