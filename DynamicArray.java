import java.util.Scanner;
class DynamicArray{
    int data[];
    int index;
DynamicArray(){
    data =new int[5];
    index=0;
}
public int checksize(){
    return index;
}
public void add(int val){
    if(index == data.length){
        restructure();
    }
    else{
        data[index]=val;
       //System.out.println(data[index]);
        index++;
    }
}
public void  restructure(){
   int temp[] =data;
   data= new int[data.length*2];
   for(int i=0;i<temp.length;i++){
    data[i] = temp[i];
   }
}
public void set(int val,int i){
    if(i>index){
        return;
    
    }
    if(i<index)
   data[i] = val;
   else{
    add(i);
   }
}
public int get(int i){
   if(i>=index) return -1;
   return (data[i]);
}
public int last(){
    int  value=0;
    if(checksize()==0) return 0;
    else{
        value = data[index-1];
        data[index-1]=0;
        index--;
    }
    return value;
}
public boolean is_empty(){
    if(checksize () ==0){
        return true ;
    }
     return false;
}



    public static void main(String[] args){
     DynamicArray  d = new DynamicArray();
      System.out.print("enter the size::");
     Scanner s = new Scanner(System.in);

     int size = s.nextInt();
     for(int i=0 ;i<size;i++){
       // System.out.println(i);
        d.add(i+10);
        
     }
     int element;
     for(int i=0;i<size;i++){
          element=d.get(i);
        System.out.println(element);
     }

     element =d.last();
     for(int i=0;i<size;i++){
        element=d.get(i);
      System.out.println(element);
   }

    }

}