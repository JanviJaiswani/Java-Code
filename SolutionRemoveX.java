public class SolutionRemoveX {
    public static String removeX(String input, int start ){
        if(input == " " || input.length()==0 ){
            String str = new String();
            return str;
        }
     String temp = removeX(input,start+1);
     System.out.println(temp+" ");
     if(input.charAt(start)!='x'){
         temp+=input.charAt(start);
         return temp;
     }
     return temp;
    }
 // Return the changed string
 public static String removeX(String input){
     return removeX(input,0);

 }
 public static void main(String[] args){
    String  str = "pxxp";
    removeX(str);
 }
}
