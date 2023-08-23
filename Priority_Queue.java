import java.util.ArrayList;

public class Priority_Queue {
   private ArrayList<Integer> heap;
   public Priority_Queue(){
    heap = new ArrayList<>();
   } 

   boolean isEmpty(){
     return heap.size() ==0;
   }

   int size(){
    return heap.size();
   }

   int getMin(){
    if(isEmpty()){
        System.out.println("Empty");
        return -1;
    }
    else{
        return heap.get(0);
    }
   }

   void insert(int ele){
     heap.add(ele);
     int child = heap.size()-1;
     int parent = (child-1)/2;

     while(child > 0){

     if(heap.get(child) < heap.get(parent)){
        int temp = heap.get(child);
        heap.set(child,heap.get(parent));
        heap.set(parent,temp);
        child =parent;
        parent = (child-1)/2;
     }
     else{
        return;
     }

    }
}

    int remove(){
        if(isEmpty()){
            System.out.print("empty");
            return -1;
        }
       
        int root = 0;
       int del = heap.get(0);
       heap.set(root,heap.get(heap.size()-1));
       heap.remove(heap.get(heap.size()-1));
       int min= root;
       int left = 1;
       int right = 2;

       while(left < heap.size()) {
        if(heap.get(left) < heap.get(root))
         min = left;

        if(right < heap.size()  && heap.get(right)<heap.get(root))
         min = right;

        if(min == root) break;

         int temp1 = heap.get(root);
        heap.set(root, heap.get(min));
         heap.set(min,temp1);

        root = min;
        left = 2*root +1;
        right = 2*root +2;
        }
         return del;
       }


      
    

    

   
   public static void main(String args[]){
       Priority_Queue pq = new Priority_Queue();
       int arr[] ={5,1,9,2,0,7,4,76,45,21};
       for(int i=0;i<arr.length;i++){
        pq.insert(arr[i]);
       }
       for(int i =0 ;i<arr.length;i++){
           System.out.println(pq.remove());
       }
      
       
   }
    



}
