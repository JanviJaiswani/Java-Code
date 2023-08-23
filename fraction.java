public class fraction{
    int num;
    int dem;

    fraction(int num ,int dem){
        this.num = num;
        this.dem =dem;
    }
    void setnum(int  num){
        this.num=num;
    }
    int getnum(int n){
        return n;
    }
    void setdem(int  dem){
        this.dem = dem;
    }

    int getden(int deno){
        return deno;
    }
    
  public void print(){
        simplify();
        if(dem ==1){
            System.out.println(num);
        }
        System.out.println(num+"/"+dem);
    }
    void  simplify(){
        int gdc=1;
        int smaller =Math.min(num,dem);
            for(int i=2;i<=smaller;i++){
                if(num%i ==0 && dem%i == 0){
                    gdc=i;
            }
            }
            num = num/gdc;
            dem = dem/gdc;

    }
   
    static public fraction add(fraction f1 ,fraction f2){
        fraction f3 = new fraction(0,0);
        f3.num =(f1.num*f2.dem)+(f2.num*f1.dem);
        f3.dem =f1.dem*f2.dem;
        return f3;
    }


    public static void main(String[] args){
      fraction f1 = new fraction(20, 30);
      fraction f2 = new fraction(10, 40);
      f1.print();
      f1.setnum(10);
      f1.setdem(25);
      f2.print();
      fraction f3 =fraction.add(f1,f2);
     
      f3.print();

    }

}