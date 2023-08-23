public class CheckArray { 
    public static boolean checksorted(int[] a){
        if(a.length<=1){
            return true;
        }
        if(a[0]>a[1]){
            return false;
        }
        int[] temp =new int[a.length-1];
        for(int i=1;i<a.length;i++){
            temp[i-1]=a[i];
        }
        return checksorted(temp);
        
    }
    public static void main(String[] args) {
        int[] arr = {2,5,8,9};
        System.out.print(checksorted(arr));
    }
}
